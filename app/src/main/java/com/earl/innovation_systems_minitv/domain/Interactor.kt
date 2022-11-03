package com.earl.innovation_systems_minitv.domain

import com.earl.innovation_systems_minitv.domain.mappers.ReportDomainToDataMapper
import com.earl.innovation_systems_minitv.domain.models.ReportDomain
import javax.inject.Inject

interface Interactor {

    suspend fun insertNewReport(report: ReportDomain)

    class Base @Inject constructor(
        private val repository: Repository,
        private val reportDomainToDataMapper: ReportDomainToDataMapper,
    ) : Interactor {
        override suspend fun insertNewReport(report: ReportDomain) {
            repository.insertNewReport(reportDomainToDataMapper.map(report))
        }
    }
}