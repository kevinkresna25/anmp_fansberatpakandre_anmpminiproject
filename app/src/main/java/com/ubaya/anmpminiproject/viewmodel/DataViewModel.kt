package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anmpminiproject.model.Pengukuran
import com.ubaya.anmpminiproject.util.FileHelper

class DataViewModel(application: Application) : AndroidViewModel(application) {
    private val fileHelper = FileHelper(application)
    val listPengukuran = MutableLiveData<List<Pengukuran>>()
    val listKosong = MutableLiveData<Boolean>()

    fun loadData() {
        val jsonString = fileHelper.readFromFile()
        if (jsonString.isNotEmpty()) {
            val gson = Gson()
            val listType = object : TypeToken<List<Pengukuran>>() {}.type
            val data: List<Pengukuran> = gson.fromJson(jsonString, listType)
            listPengukuran.value = data
            listKosong.value = false
        } else {
            listKosong.value = true
        }
    }
}