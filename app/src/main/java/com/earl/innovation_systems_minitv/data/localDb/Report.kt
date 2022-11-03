package com.earl.innovation_systems_minitv.data.localDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reports")
data class Report (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name ="id_video") val videoId: Int,
    @ColumnInfo(name ="video_name") val videoName: String,
    @ColumnInfo(name ="start_time") val startTime: String,
)