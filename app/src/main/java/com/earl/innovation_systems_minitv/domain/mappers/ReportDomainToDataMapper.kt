package com.earl.innovation_systems_minitv.domain.mappers

import com.earl.innovation_systems_minitv.data.models.ReportData
import com.earl.innovation_systems_minitv.domain.models.ReportDomain
import javax.inject.Inject

interface ReportDomainToDataMapper {

    fun map(report: ReportDomain) : ReportData

    class Base @Inject constructor() : ReportDomainToDataMapper {
        override fun map(report: ReportDomain) = ReportData(report.VideoId, report.VideoName, report.timestamp)
    }
}