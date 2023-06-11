package com.capstone.protani.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Lens
import androidx.compose.material.icons.sharp.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.capstone.protani.R
import com.capstone.protani.ml.ModelUnquant
import com.capstone.protani.ui.viewmodels.PlantViewModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private var shouldShowCamera = mutableStateOf(false)
private var shouldShowStorage:Boolean? = null
private var shouldShowPhoto:MutableState<Boolean> = mutableStateOf(false)
private var uriPhoto:Uri?=null
private var outputResult:MutableState<String> = mutableStateOf("")

var imageProcessor: ImageProcessor = ImageProcessor.Builder()
    .add(ResizeOp(224, 224, ResizeOp.ResizeMethod.BILINEAR))
    .add(NormalizeOp(0.0f, 255.0f))
    .build()

@Composable
fun CameraView(
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit,
){

    val lensFacing = CameraSelector.LENS_FACING_BACK
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val storageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()){uri:Uri?->
        Glide.with(context)
            .asBitmap()
            .apply(RequestOptions().override(600,600))
            .load(uri)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    outputResult.value = outputGenerator(resource, context)
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })
    }
    //permission launcher
        val permissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                shouldShowStorage = true
            }
        }
        //permission for external storage
        when{
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED -> {
                shouldShowStorage = true
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                LocalContext.current as Activity,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)->
                shouldShowStorage = true
            else->{
                SideEffect {
                    permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
        }

    val preview = androidx.camera.core.Preview.Builder().build()
    val previewView = remember { PreviewView(context) }
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()

    LaunchedEffect(lensFacing) {
        val cameraProvider = ProcessCameraProvider.getInstance(context)
        cameraProvider.addListener({
            val camera = cameraProvider.get()
            camera.unbindAll()
            camera.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )
            preview.setSurfaceProvider(previewView.surfaceProvider)
        },ContextCompat.getMainExecutor(context))
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
        popUp(result = outputResult.value)
    }
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 30.dp)) {
        IconButton(
            modifier = Modifier.padding(bottom = 20.dp),
            onClick = {
                takePhoto(
                    filenameFormat = "yyyy-MM-dd-HH-mm-ss-SSS",
                    imageCapture = imageCapture,
                    outputDirectory = outputDirectory,
                    executor = executor,
                    onImageCaptured = onImageCaptured,
                    onError = onError
                )
            },
            //Buat aksi klasifikasi
            content = {
                Icon(
                    imageVector = Icons.Sharp.Lens,
                    contentDescription = "Take picture",
                    tint = Color.White,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(1.dp)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        )
        IconButton(
            modifier = Modifier
                .padding(bottom = 30.dp, end = 30.dp)
                .align(Alignment.BottomEnd),
            onClick = {
                if(shouldShowStorage == true)storageLauncher.launch("image/*")
                else Toast.makeText(context,"Permission not granted!",Toast.LENGTH_SHORT).show() },
            content = {
                Icon(
                    imageVector = Icons.Sharp.Upload,
                    contentDescription = "upload picture",
                    tint = Color.White,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(1.dp)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        )
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CameraScannerScreen(navHostController: NavHostController,context:Context){
    val plantViewModel = viewModel<PlantViewModel>()
    Scaffold(modifier=Modifier.fillMaxSize()) {
        //permission launcher
        val permissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                shouldShowCamera.value = true
            }
        }
        //permission for camera
        when{
            ContextCompat.checkSelfPermission(context,android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED->{
                shouldShowCamera.value = true
            }
            ActivityCompat.shouldShowRequestPermissionRationale(LocalContext.current as Activity,android.Manifest.permission.CAMERA)
            -> shouldShowCamera.value = true
            else->{
                SideEffect {
                    permissionLauncher.launch(android.Manifest.permission.CAMERA)
                }
            }
        }

        //camera execution
        val cameraExecutor:ExecutorService = Executors.newSingleThreadExecutor()
        val outputDirectory = getOutputDirectory(context = context)

        if(shouldShowCamera.value){
            CameraView(
                outputDirectory = outputDirectory,
                executor = cameraExecutor,
                onImageCaptured = ::handleImageCapture,
                onError = {Log.e("error image capture","view error : $it")}
            )
        }
        if(shouldShowPhoto.value){
            Box(modifier = Modifier.fillMaxSize()){
                //resizing photo bitmap
                Glide.with(context)
                    .asBitmap()
                    .apply(RequestOptions().override(600,600))
                    .load(uriPhoto)
                    .into(object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            outputResult.value = outputGenerator(resource, context)
                        }
                        override fun onLoadCleared(placeholder: Drawable?) {
                            // this is called when imageView is cleared on lifecycle call or for
                            // some other reason.
                            // if you are referencing the bitmap somewhere else too other than this imageView
                            // clear it here as you can no longer have the bitmap
                        }
                    })
            }
        }
        //when camera destroyed
        DisposableEffect(Unit){
            onDispose {
                cameraExecutor.shutdown()
            }

        }

    }

}

private fun takePhoto(
    filenameFormat: String,
    imageCapture: ImageCapture,
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit
){
    val photoFile = File(
        outputDirectory,
        SimpleDateFormat(filenameFormat, Locale.US).format(System.currentTimeMillis()) + ".jpg"
    )

    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    imageCapture.takePicture(outputOptions, executor, object: ImageCapture.OnImageSavedCallback {
        override fun onError(exception: ImageCaptureException) {
            Log.e("error take photo", "Take photo error:", exception)
            onError(exception)
        }

        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
            val savedUri = Uri.fromFile(photoFile)
            onImageCaptured(savedUri)
        }
    })
    suspend fun Context.getCameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }
}
private fun handleImageCapture(uri: Uri) {
    uriPhoto = uri
    shouldShowCamera.value = false
    shouldShowPhoto.value= true
}

private fun getOutputDirectory(context:Context): File {
    val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
        File(it, context.resources.getString(R.string.app_name)).apply { mkdirs() }
    }
    return if ((mediaDir != null) && mediaDir.exists()) mediaDir else context.filesDir
}
@Composable
fun popUp(result:String){
    Box{
        Text(
            modifier=Modifier.align(Alignment.TopCenter),
            text = result,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
private fun outputGenerator(bitmap: Bitmap,context: Context):String{
    val model = ModelUnquant.newInstance(context)

    var tensorImage = TensorImage(DataType.FLOAT32)
    tensorImage.load(bitmap)

    tensorImage = imageProcessor.process(tensorImage)

    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
    inputFeature0.loadBuffer(tensorImage.buffer)

    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

    val maxIdx = outputFeature0.indices.maxByOrNull { outputFeature0[it] } ?: -1

    val maxIdValues = arrayOf("Bacterial Blight","Blast","Brownspot","Healthy","Tungro")
    val result = maxIdValues[maxIdx]
    model.close()
    return result
}