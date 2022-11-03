package com.earl.innovation_systems_minitv.data.mappers

import com.earl.innovation_systems_minitv.data.models.ReportData
import com.earl.innovation_systems_minitv.domain.models.ReportDomain
import javax.inject.Inject

interface ReportReportDataToDomainMapper {

    fun map(report: ReportData) : ReportDomain

    class Base @Inject constructor() : ReportReportDataToDomainMapper {
        override fun map(report: ReportData) = ReportDomain(report.VideoId, report.VideoName, report.timestamp)
    }
}