package com.earl.innovation_systems_minitv.domain

import com.earl.innovation_systems_minitv.data.models.ReportData

interface Repository {

    suspend fun insertNewReport(report: ReportData)
}