package com.earl.innovation_systems_minitv.di

import com.earl.innovation_systems_minitv.data.BaseRepository
import com.earl.innovation_systems_minitv.data.localDb.AppDatabase
import com.earl.innovation_systems_minitv.data.localDb.ReportsDao
import com.earl.innovation_systems_minitv.data.mappers.ReportDataToDbMapper
import com.earl.innovation_systems_minitv.data.mappers.ReportReportDataToDomainMapper
import com.earl.innovation_systems_minitv.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRepository(impl: BaseRepository) : Repository

    @Binds
    abstract fun bindReportDataToDomainMapper(base: ReportReportDataToDomainMapper.Base) : ReportReportDataToDomainMapper

    @Binds
    abstract fun bindReportDataToDbMapper(base: ReportDataToDbMapper.Base) : ReportDataToDbMapper
}