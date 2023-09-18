package com.aleiva.hcompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aleiva.hcompose.data.model.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun heroDao(): HeroDao

  companion object {
    fun getInstance(context: Context): AppDatabase {
      return Room.databaseBuilder(context, AppDatabase::class.java, "hero_compose_db")
        .allowMainThreadQueries()
        .build()
    }
  }
}