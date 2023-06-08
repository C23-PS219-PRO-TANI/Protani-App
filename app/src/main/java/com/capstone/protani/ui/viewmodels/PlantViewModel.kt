package com.capstone.protani.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.protani.domain.model.Disease

class PlantViewModel:ViewModel() {
    private val _dataDesease = MutableLiveData<String>()
    val dataDesease:LiveData<String> = _dataDesease

    fun setDesease(name:String){_dataDesease.value = name}
}