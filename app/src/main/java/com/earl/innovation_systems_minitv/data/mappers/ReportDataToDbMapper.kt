package com.earl.innovation_systems_minitv.data.mappers

import com.earl.innovation_systems_minitv.data.localDb.Report
import com.earl.innovation_systems_minitv.data.models.ReportData
import javax.inject.Inject

interface ReportDataToDbMapper {

    fun map(data: ReportData) : Report

    class Base @Inject constructor() : ReportDataToDbMapper {
        override fun map(data: ReportData) = Report(0, data.VideoId, data.VideoName, data.timestamp)
    }
}