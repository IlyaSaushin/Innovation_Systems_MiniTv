package com.earl.innovation_systems_minitv.data.localDb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Report::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reportsDao() : ReportsDao
}