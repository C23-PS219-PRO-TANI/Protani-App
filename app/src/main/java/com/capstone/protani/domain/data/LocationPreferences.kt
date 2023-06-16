package com.capstone.protani.domain.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "location")
class LocationPreferences private constructor(private val dataStore:DataStore<Preferences>
){
    suspend fun setLocation(key:String, value:LatLng){
        val preferencesKey = stringPreferencesKey(key)
        dataStore.edit { preferences->
            preferences[preferencesKey] = value.toString()
        }
    }
    fun getLocation(key: String):Flow<String?>{
         val preferencesKey = stringPreferencesKey(key)
        return dataStore.data.map { preferences->
            preferences[preferencesKey]
        }
    }
    companion object{
        @Volatile
        private var INSTANCE : LocationPreferences?=null
        fun getInstance(dataStore: DataStore<Preferences>):LocationPreferences{
            return INSTANCE?: synchronized(this){
                val instance = LocationPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }

    }
}