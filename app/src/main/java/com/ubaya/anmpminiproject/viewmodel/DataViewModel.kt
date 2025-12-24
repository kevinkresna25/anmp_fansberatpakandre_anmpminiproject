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
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DataViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
//    private val fileHelper = FileHelper(application)
//    val listPengukuran = MutableLiveData<List<Pengukuran>>()
//    val listKosong = MutableLiveData<Boolean>()

    private val job = Job()

    val ukurListLD = MutableLiveData<List<UkurData>>()
    val loadingLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.postValue(true)
        errorLD.postValue(false)

        launch {
            try {
                val db = buildDb(getApplication())
                val data = db.ukurDao().selectAllUkur()
                ukurListLD.postValue(data)
            } catch (e: Exception) {
                errorLD.postValue(true)
            } finally {
                loadingLD.postValue(false)
            }
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