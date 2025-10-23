package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.anmpminiproject.util.SharedPrefHelper

class ProfilViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPrefHelper = SharedPrefHelper(application)

    val nama = MutableLiveData<String>()
    val tglLahir = MutableLiveData<String>()
    val jenisKelamin = MutableLiveData<String>()
    val saveStatus = MutableLiveData<Boolean?>()

    fun loadProfil() {
        nama.value = sharedPrefHelper.getNama()
        tglLahir.value = sharedPrefHelper.getTglLahir()
        jenisKelamin.value = sharedPrefHelper.getJenisKelamin()
    }

    fun simpanProfil(nama: String, tglLahir: String, jenisKelamin: String) {
        try {
            sharedPrefHelper.simpanProfil(nama, tglLahir, jenisKelamin)
            saveStatus.value = true
            resetStatus()
        } catch (e: Exception) {
            e.printStackTrace()
            saveStatus.value = false
            resetStatus()
        }
    }

    fun resetStatus() {
        saveStatus.value = null
    }
}