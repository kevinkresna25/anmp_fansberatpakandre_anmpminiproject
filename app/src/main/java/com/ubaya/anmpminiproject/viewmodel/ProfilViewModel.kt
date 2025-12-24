package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.anmpminiproject.model.ProfilData
import com.ubaya.anmpminiproject.util.SharedPrefHelper
import com.ubaya.anmpminiproject.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProfilViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
//    private val sharedPrefHelper = SharedPrefHelper(application)
//    val saveStatus = MutableLiveData<Boolean?>()

    private val job = Job()

    val nama = MutableLiveData<String>()
    val tglLahir = MutableLiveData<String>()
    val jenisKelamin = MutableLiveData<Int>()
    val statusSimpan = MutableLiveData<Boolean?>()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

//    fun loadProfil() {
//        nama.value = sharedPrefHelper.getNama()
//        tglLahir.value = sharedPrefHelper.getTglLahir()
//        jenisKelamin.value = sharedPrefHelper.getJenisKelamin()
//    }

    fun fetch() {
        launch {
            val db = buildDb(getApplication())
            val profil = db.ukurDao().getProfil()

            if (profil != null) {
                nama.postValue(profil.nama)
                tglLahir.postValue(profil.tglLahir)
                jenisKelamin.postValue(profil.jenisKelamin)
            } else {
                jenisKelamin.postValue(0) // Default Laki-laki
            }
        }
    }

    fun simpanProfil() {
        if (!nama.value.isNullOrEmpty() && !tglLahir.value.isNullOrEmpty() && jenisKelamin.value != null) {
            val dataProfil = ProfilData(
                nama = nama.value!!,
                tglLahir = tglLahir.value!!,
                jenisKelamin = jenisKelamin.value!!,
                id = 1 // supaya selalu update record yang sama
            )

            launch {
                val db = buildDb(getApplication())
                db.ukurDao().insertOrUpdateProfil(dataProfil)
                statusSimpan.postValue(true) // Kabari fragment kalau sukses
            }
        }
    }

    fun resetStatus() {
        statusSimpan.value = null
    }
}