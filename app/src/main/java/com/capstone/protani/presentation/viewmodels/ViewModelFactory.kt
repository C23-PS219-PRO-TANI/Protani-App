package com.capstone.protani.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.protani.domain.data.LocationPreferences

class ViewModelFactory():ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MapViewModel::class.java)){
            return MapViewModel() as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class:${modelClass.name}")
    }
}