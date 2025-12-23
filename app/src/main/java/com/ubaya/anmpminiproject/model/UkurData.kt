package com.ubaya.anmpminiproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ukur_history") // nama tabel
data class UkurData(
    @ColumnInfo(name = "berat")
    var berat: String,

    @ColumnInfo(name = "tinggi")
    var tinggi: String,

    @ColumnInfo(name = "usia")
    var usia: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
