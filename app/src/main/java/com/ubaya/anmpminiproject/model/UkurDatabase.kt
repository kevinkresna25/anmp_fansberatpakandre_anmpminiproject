package com.ubaya.anmpminiproject.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.anmpminiproject.util.DB_NAME

@Database(entities = [UkurData::class, ProfilData::class], version = 1)
abstract class UkurDatabase : RoomDatabase() {
    abstract fun ukurDao(): UkurDao

    companion object {
        @Volatile
        private var instance: UkurDatabase? = null
        private val LOCK = Any()

        fun buildDatabase(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                UkurDatabase::class.java,
                DB_NAME
            ).build().also { instance = it }
        }
    }
}
