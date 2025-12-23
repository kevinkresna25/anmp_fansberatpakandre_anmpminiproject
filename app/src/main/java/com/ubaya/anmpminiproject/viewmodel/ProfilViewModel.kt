package com.ubaya.anmpminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.anmpminiproject.model.ProfilData
import com.ubaya.anmpminiproject.util.SharedPrefHelper
import com.ubaya.anmpminiproject.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfilViewModel(application: Application) : AndroidViewModel(application) {
//    private val sharedPrefHelper = SharedPrefHelper(application)
//    val saveStatus = MutableLiveData<Boolean?>()
    val nama = MutableLiveData<String>()
    val tglLahir = MutableLiveData<String>()
    val jenisKelamin = MutableLiveData<String>()

//    fun loadProfil() {
//        nama.value = sharedPrefHelper.getNama()
//        tglLahir.value = sharedPrefHelper.getTglLahir()
//        jenisKelamin.value = sharedPrefHelper.getJenisKelamin()
//    }

    fun fetch() {
        CoroutineScope(Dispatchers.IO).launch {
            val db = buildDb(getApplication())
            val profil = db.ukurDao().getProfil()

            // Jika ada data profil di database, update variable
            profil?.let {
                nama.postValue(it.nama)
                tglLahir.postValue(it.tglLahir)
                jenisKelamin.postValue(it.jenisKelamin)
            }
        }
    }

    fun simpanProfil() {
        if (!nama.value.isNullOrEmpty() && !tglLahir.value.isNullOrEmpty() && !jenisKelamin.value.isNullOrEmpty()) {
            val dataProfil = ProfilData(
                nama = nama.value!!,
                tglLahir = tglLahir.value!!,
                jenisKelamin = jenisKelamin.value!!
            )

            CoroutineScope(Dispatchers.IO).launch {
                val db = buildDb(getApplication())
                db.ukurDao().insertOrUpdateProfil(dataProfil)
            }
        }
    }

//    fun resetStatus() {
//        saveStatus.value = null
//    }
}