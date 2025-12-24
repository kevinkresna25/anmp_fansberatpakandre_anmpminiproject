package com.ubaya.anmpminiproject.util

import android.content.Context
import androidx.room.Room
import com.ubaya.anmpminiproject.model.UkurDatabase

val DB_NAME = "db_anmp_ukur"

fun buildDb(context: Context): UkurDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        UkurDatabase::class.java,
        DB_NAME
    )
        .build()
}