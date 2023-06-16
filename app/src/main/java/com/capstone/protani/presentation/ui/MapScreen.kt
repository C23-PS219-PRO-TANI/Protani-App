package com.capstone.protani.presentation.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.capstone.protani.data.remote.api.ApiService
import com.capstone.protani.domain.model.DataX
import com.capstone.protani.domain.model.Map
import com.capstone.protani.presentation.ui.components.LoadingScreen
import com.capstone.protani.presentation.ui.navigation.Screen
import com.capstone.protani.presentation.viewmodels.MapViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

private var shouldShowMaps:Boolean=false
@Composable
fun MapScreen(navHostController: NavHostController,context:Context) {
    val mapViewModel:MapViewModel = viewModel()
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract =ActivityResultContracts.RequestPermission(),
        onResult ={ isGranted->
            shouldShowMaps = if(isGranted){
                true
            }else{
                navHostController.navigate(Screen.Home.route)
                Toast.makeText(context,"Permission not granted!", Toast.LENGTH_SHORT).show()
                false
            }
        }
    )
    //permissions
    when{
        ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED -> {
            shouldShowMaps = true
        }
        ActivityCompat.shouldShowRequestPermissionRationale(
            LocalContext.current as Activity,
            Manifest.permission.ACCESS_FINE_LOCATION)->
            shouldShowMaps = true
        else->{
            SideEffect {
                locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }
    //add data coordinate
    mapViewModel.getAllCoordinate()
    val listOfLatLng = ArrayList<LatLng>()
    val allData = mapViewModel.allCoordinate.observeAsState()
    val apiStatus = mapViewModel.getStatus().observeAsState(ApiService.ApiStatus.LOADING)
    if(apiStatus.value == ApiService.ApiStatus.SUCCESS){
        LoadingScreen(visible = false)
    }else{
        LoadingScreen(visible = true)
    }
    allData.value?.map { map ->
        val coordinates = map.coordinat.trim().split(" ")
        val latitude = coordinates[0].toDouble()
        val longitude = coordinates[1].toDouble()
        val latLng = LatLng(latitude, longitude)
        listOfLatLng.add(latLng)
        //positioning camera when we have coordinate
        val cameraPositionState = rememberCameraPositionState {
            fusedLocationClient.lastLocation.addOnSuccessListener { currentLocation->
                position = if (listOfLatLng.isEmpty()) {
                    // Menggunakan lokasi saat ini
                    CameraPosition.fromLatLngZoom(
                        LatLng(currentLocation.latitude, currentLocation.longitude),
                        50f
                    )
                } else {
                    // Menggunakan posisi pertama dalam listOfLatLng
                    CameraPosition.fromLatLngZoom(
                        listOfLatLng.last(),
                        50f
                    )
                }

            }
        }

        val markerPositionState = remember { mutableListOf(listOfLatLng) }
        Log.d("dataLtlg","$markerPositionState")
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {

            markerPositionState.map { fragmentPosition->
                fragmentPosition.map { dataLatlng->
                    Marker(
                        state = MarkerState(position = dataLatlng),
                        title = "Lokasi scanning",
                        snippet = "Lokasi sawah anda"
                    )
                }
            }
        }

    }
}
