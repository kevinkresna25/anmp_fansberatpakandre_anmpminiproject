package com.ubaya.anmpminiproject.util

import android.content.Context

class SharedPrefHelper(context: Context) {
    private val PREF_NAME = "UkurAnakProfile"
    private val KEY_NAMA = "nama"
    private val KEY_TGL_LAHIR = "tglLahir"
    private val KEY_JENIS_KELAMIN = "jenisKelamin"

    private val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()

    fun simpanProfil(nama: String, tglLahir: String, jenisKelamin: String) {
        editor.putString(KEY_NAMA, nama)
        editor.putString(KEY_TGL_LAHIR, tglLahir)
        editor.putString(KEY_JENIS_KELAMIN, jenisKelamin)
        editor.apply()
    }

    fun getNama(): String? = sharedPref.getString(KEY_NAMA, "")
    fun getTglLahir(): String? = sharedPref.getString(KEY_TGL_LAHIR, "")
    fun getJenisKelamin(): String? = sharedPref.getString(KEY_JENIS_KELAMIN, "")
}