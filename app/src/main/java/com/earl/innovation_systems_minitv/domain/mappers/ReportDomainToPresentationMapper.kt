package com.earl.innovation_systems_minitv.domain.mappers

import com.earl.innovation_systems_minitv.domain.models.ReportDomain
import com.earl.innovation_systems_minitv.presentation.models.ReportPresentation
import javax.inject.Inject

interface ReportDomainToPresentationMapper {

    fun map(report: ReportDomain) : ReportPresentation

    class Base @Inject constructor() : ReportDomainToPresentationMapper {
        override fun map(report: ReportDomain) = ReportPresentation(report.VideoId, report.VideoName, report.timestamp)
    }
}