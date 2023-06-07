package com.capstone.protani

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.capstone.protani.ui.navigation.SetupNavGraph
import com.capstone.protani.ui.theme.ProtaniTheme

class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if(isGranted){
            Log.i("permissions","permissions Granted!")
        }else{
            Log.i("permissions","permissions Rejected!")
        }
    }
    private fun requestCameraPermissions(){
        when{
            ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED->{
                        Log.i("camera permission","Camera Permission previously Granted!")
                    }
            ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CAMERA)
                    ->Log.i("camera permission","show camera permissions dialog")
            else->requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }
    private fun requestPermissionStorage(){
        when {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED -> {
                        Log.i("storage permission","storage permission previously granted!")
                    }
            ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)->Log.i("storage permission","Storage permission granted!")
            else->requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProtaniTheme {
                val controller = rememberNavController()
                SetupNavGraph(navController = controller)
            }
        }
        requestPermissionStorage()
        requestCameraPermissions()
    }
}
