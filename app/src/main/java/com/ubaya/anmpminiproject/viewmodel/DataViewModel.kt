package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anmpminiproject.model.Pengukuran
import com.ubaya.anmpminiproject.model.UkurData
import com.ubaya.anmpminiproject.util.FileHelper
import com.ubaya.anmpminiproject.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) : AndroidViewModel(application) {
//    private val fileHelper = FileHelper(application)
//    val listPengukuran = MutableLiveData<List<Pengukuran>>()
//    val listKosong = MutableLiveData<Boolean>()
    val ukurListLD = MutableLiveData<List<UkurData>>()

    fun refresh() {
        CoroutineScope(Dispatchers.IO).launch {
            val db = buildDb(getApplication())
            // Ambil semua data dari tabel
            val data = db.ukurDao().selectAllUkur()
            ukurListLD.postValue(data)
        }
    }

//    fun loadData() {
//        val jsonString = fileHelper.readFromFile()
//        if (jsonString.isNotEmpty()) {
//            val gson = Gson()
//            val listType = object : TypeToken<List<Pengukuran>>() {}.type
//            val data: List<Pengukuran> = gson.fromJson(jsonString, listType)
//            listPengukuran.value = data
//            listKosong.value = false
//        } else {
//            listKosong.value = true
//        }
//    }
}