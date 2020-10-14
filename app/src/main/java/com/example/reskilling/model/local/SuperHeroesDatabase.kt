package com.example.reskilling.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.security.AccessControlContext

@Database(entities = [SuperHeroesEntity::class], version = 1)
@TypeConverters(HeightTypeConverter::class)
abstract class SuperHeroesDatabase : RoomDatabase() {
    //dao
    abstract fun superHeroesDao(): SuperHeroesDao

    companion object {
        @Volatile
        private var INSTANCE : SuperHeroesDatabase? = null

        fun getDatabase(context: Context): SuperHeroesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    SuperHeroesDatabase::class.java,
                    "superHeroDb")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}