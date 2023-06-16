package com.capstone.protani.presentation.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.protani.data.remote.api.ApiConfig
import com.capstone.protani.data.remote.api.ApiService
import com.capstone.protani.domain.model.DataX
import com.capstone.protani.domain.model.GetAllMapResponse
import com.capstone.protani.domain.model.Map
import com.capstone.protani.domain.model.MapResponse
import com.google.android.gms.maps.model.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapViewModel :ViewModel() {
    private val status = MutableLiveData<ApiService.ApiStatus>()
    fun getStatus(): LiveData<ApiService.ApiStatus> = status
    private val _allCoordinate:MutableLiveData<List<DataX>> = MutableLiveData()
    val allCoordinate:LiveData<List<DataX>> = _allCoordinate

    var successCreated:String?=null

    fun coordinate(coordinate:String,provence:String,city:String,address:String){
        val modelMap = Map(coordinate, provence, city, address)
        val clientApi = ApiConfig.getMapApiService().setLocation(modelMap)
        status.postValue(ApiService.ApiStatus.LOADING)
        clientApi.enqueue(object : Callback<MapResponse>{
            override fun onResponse(call: Call<MapResponse>, response: Response<MapResponse>) {
                if(response.isSuccessful){
                    successCreated = response.body()?.message
                    Log.d("coordinate success","${response.body()?.message}")
                    status.postValue(ApiService.ApiStatus.LOADING)
                }else{
                    Log.e("response failure","${response.errorBody()}")
                    status.postValue(ApiService.ApiStatus.FAILED)
                }
            }

            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
                Log.e("response failure","${t.message}")
                status.postValue(ApiService.ApiStatus.FAILED)
            }

        })
    }
    fun getAllCoordinate(){
        val clientApi = ApiConfig.getMapApiService().getAllCoordinate()
        status.postValue(ApiService.ApiStatus.LOADING)
        clientApi.enqueue(object : Callback<GetAllMapResponse>{
            override fun onResponse(call: Call<GetAllMapResponse>, response: Response<GetAllMapResponse>) {
                if(response.isSuccessful){
                    _allCoordinate.value =response.body()?.data?.data
                    status.postValue(ApiService.ApiStatus.SUCCESS)
                }else{
                    Log.e("response failure","${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<GetAllMapResponse>, t: Throwable) {
                status.postValue(ApiService.ApiStatus.FAILED)
                Log.e("response failure","${t.message}")
            }

        })
    }
}