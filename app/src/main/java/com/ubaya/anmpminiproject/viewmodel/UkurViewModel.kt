package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anmpminiproject.model.Pengukuran
import com.ubaya.anmpminiproject.util.FileHelper

class UkurViewModel(application: Application) : AndroidViewModel(application) {
    private val fileHelper = FileHelper(application)
    val saveStatus = MutableLiveData<Boolean>()

    fun simpanPengukuran(pengukuranBaru: Pengukuran) {
        try {
            val jsonString = fileHelper.readFromFile()
            val gson = Gson()
            val listType = object : TypeToken<MutableList<Pengukuran>>() {}.type

            val daftarPengukuran: MutableList<Pengukuran> = if (jsonString.isNotEmpty()) {
                gson.fromJson(jsonString, listType)
            } else {
                mutableListOf()
            }

            // Tambah data baru ke list
            daftarPengukuran.add(pengukuranBaru)

            // Ubah list yang sudah diperbarui menjadi JSON
            val newJsonString = gson.toJson(daftarPengukuran)

            // Tulis kembali ke file
            fileHelper.writeToFile(newJsonString)
            saveStatus.value = true
        } catch (e: Exception) {
            e.printStackTrace()
            saveStatus.value = false
        }
    }
}