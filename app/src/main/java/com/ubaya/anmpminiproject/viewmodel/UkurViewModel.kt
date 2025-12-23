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

class UkurViewModel(application: Application) : AndroidViewModel(application) {
//    private val fileHelper = FileHelper(application)
//    val saveStatus = MutableLiveData<Boolean?>()
    val berat = MutableLiveData<String>()
    val tinggi = MutableLiveData<String>()
    val usia = MutableLiveData<String>()

    fun tambahData() {
        if (!berat.value.isNullOrEmpty() && !tinggi.value.isNullOrEmpty() && !usia.value.isNullOrEmpty()) {
            val dataBaru = UkurData(
                berat = berat.value!!,
                tinggi = tinggi.value!!,
                usia = usia.value!!
            )

            CoroutineScope(Dispatchers.IO).launch {
                val db = buildDb(getApplication()) // Panggil database
                db.ukurDao().insertUkur(dataBaru) // Simpan data
            }

            // Reset form setelah simpan
            berat.value = ""
            tinggi.value = ""
            usia.value = ""
        }
    }

//    fun simpanPengukuran(pengukuranBaru: Pengukuran) {
//        try {
//            val jsonString = fileHelper.readFromFile()
//            val gson = Gson()
//            val listType = object : TypeToken<MutableList<Pengukuran>>() {}.type
//
//            val daftarPengukuran: MutableList<Pengukuran> = if (jsonString.isNotEmpty()) {
//                gson.fromJson(jsonString, listType)
//            } else {
//                mutableListOf()
//            }
//
//            // Tambah data baru ke list
//            daftarPengukuran.add(pengukuranBaru)
//
//            // Ubah list yang sudah diperbarui menjadi JSON
//            val newJsonString = gson.toJson(daftarPengukuran)
//
//            // Tulis kembali ke file
//            fileHelper.writeToFile(newJsonString)
//            saveStatus.value = true
//            resetStatus()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            saveStatus.value = false
//            resetStatus()
//        }
//    }
//
//    fun resetStatus() {
//        saveStatus.value = null
//    }
}