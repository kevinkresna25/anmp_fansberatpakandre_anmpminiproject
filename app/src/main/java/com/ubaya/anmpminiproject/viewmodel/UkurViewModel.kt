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

class UkurViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    val berat = MutableLiveData<String>()
    val tinggi = MutableLiveData<String>()
    val usia = MutableLiveData<String>()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun tambahData() {
        if (!berat.value.isNullOrEmpty() && !tinggi.value.isNullOrEmpty() && !usia.value.isNullOrEmpty()) {

            val dataBaru = UkurData(
                berat = berat.value!!,
                tinggi = tinggi.value!!,
                usia = usia.value!!
            )

            launch {
                val db = buildDb(getApplication())
                db.ukurDao().insertUkur(dataBaru)
            }

            berat.postValue("")
            tinggi.postValue("")
            usia.postValue("")
        }
    }
}