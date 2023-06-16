package com.capstone.protani.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.protani.data.remote.api.ApiConfig
import com.capstone.protani.data.remote.api.ApiService
import com.capstone.protani.domain.model.Map
import com.google.android.gms.maps.model.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapViewModel :ViewModel() {
    private val status = MutableLiveData<ApiService.ApiStatus>()
    private val _location:MutableLiveData<Map> = MutableLiveData()
    val getCoordinate:LiveData<Map> = _location

    private val _allCoordinate:MutableLiveData<List<Map>> = MutableLiveData()
    val allCoordinate:LiveData<List<Map>> = _allCoordinate

    fun getStatus(): LiveData<ApiService.ApiStatus> = status
    fun coordinate(coordinate:LatLng,provence:String,city:String,address:String){
        val modelMap = Map(coordinate, provence, city, address)
        val clientApi = ApiConfig.getMapApiService().setLocation(modelMap)
        clientApi.enqueue(object : Callback<Map>{
            override fun onResponse(call: Call<Map>, response: Response<Map>) {
                _location.value = response.body()
                Log.d("map coordinate","${response.body()?.coordinate}")
            }

            override fun onFailure(call: Call<Map>, t: Throwable) {
                Log.e("response failure","${t.message}")
            }

        })
    }
    fun getAllCoordinate(){
        val clientApi = ApiConfig.getMapApiService().getAllCoordinate()
        clientApi.enqueue(object : Callback<List<Map>>{
            override fun onResponse(call: Call<List<Map>>, response: Response<List<Map>>) {
                _allCoordinate.value = response.body()
                Log.d("total coordinate","${response.body()?.size}")
            }

            override fun onFailure(call: Call<List<Map>>, t: Throwable) {
                Log.e("response failure","${t.message}")
            }

        })
    }
}