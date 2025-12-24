package com.ubaya.anmpminiproject.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UkurDao {
    // Untuk Fragment Ukur & Data
    @Insert
    fun insertUkur(ukur: UkurData) // Fungsi nambah data ukur

    @Query("SELECT * FROM ukur_history ORDER BY id DESC")
    fun selectAllUkur(): List<UkurData> // Fungsi ambil semua data

    // Untuk Fragment Profil
    // onConflict = REPLACE artinya kalau ID-nya sama, timpa data lama.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateProfil(profil: ProfilData)

    @Query("SELECT * FROM profil_anak WHERE id = 1")
    fun getProfil(): ProfilData
}
