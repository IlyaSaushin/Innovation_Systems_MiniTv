package com.earl.innovation_systems_minitv.presentation.mappers

import com.earl.innovation_systems_minitv.domain.models.ReportDomain
import com.earl.innovation_systems_minitv.presentation.models.ReportPresentation
import javax.inject.Inject

interface ReportPresentationToDomainMapper {

    fun map(report: ReportPresentation) : ReportDomain

    class Base @Inject constructor() : ReportPresentationToDomainMapper {
        override fun map(report: ReportPresentation) = ReportDomain(report.VideoId, report.VideoName, report.timestamp)
    }
}