package com.ubaya.anmpminiproject.util

import android.content.Context
import androidx.room.Room
import com.ubaya.anmpminiproject.model.UkurDatabase

val DB_NAME = "anmp_ukur_db"

fun buildDb(context: Context): UkurDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        UkurDatabase::class.java,
        DB_NAME
    )
        .build()
}