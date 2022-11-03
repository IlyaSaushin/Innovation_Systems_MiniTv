package com.earl.innovation_systems_minitv.data

import com.earl.innovation_systems_minitv.data.localDb.AppDatabase
import com.earl.innovation_systems_minitv.data.mappers.ReportDataToDbMapper
import com.earl.innovation_systems_minitv.data.models.ReportData
import com.earl.innovation_systems_minitv.domain.Repository
import javax.inject.Inject

class BaseRepository @Inject constructor(
    private val appDb: AppDatabase,
    private val reportDataToDbMapper: ReportDataToDbMapper
) : Repository {

    override suspend fun insertNewReport(report: ReportData) {
        appDb.reportsDao().insertVideoReport(reportDataToDbMapper.map(report))
    }
}