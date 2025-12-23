package com.ubaya.anmpminiproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profil_anak")
data class ProfilData(
    @ColumnInfo(name = "nama")
    var nama: String,

    @ColumnInfo(name = "tgl_lahir")
    var tglLahir: String,

    @ColumnInfo(name = "jenis_kelamin")
    var jenisKelamin: String
) {
    @PrimaryKey
    var id: Int = 1
}
