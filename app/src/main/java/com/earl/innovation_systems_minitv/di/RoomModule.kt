package com.earl.innovation_systems_minitv.di

import android.content.Context
import androidx.room.Room
import com.earl.innovation_systems_minitv.data.localDb.AppDatabase
import com.earl.innovation_systems_minitv.data.localDb.ReportsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

/*    @Provides
    @Singleton
    fun localDataBase(context: Context) : AppDatabase {
        val tempInstance = AppDatabase.INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "minitv.db"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            AppDatabase.INSTANCE = instance
            return instance
        }
    }*/

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "minitv.db"
    ).build()

    @Provides
    fun provideReportDao(appDatabase: AppDatabase): ReportsDao {
        return appDatabase.reportsDao()
    }
}