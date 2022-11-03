package com.earl.innovation_systems_minitv.data.localDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReportsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVideoReport(report: Report)

    @Query("SELECT * FROM reports")
    fun selectAllReports() : List<Report>
}