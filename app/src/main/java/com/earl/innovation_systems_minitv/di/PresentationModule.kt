package com.earl.innovation_systems_minitv.di

import com.earl.innovation_systems_minitv.presentation.mappers.ReportPresentationToDomainMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationModule {

    @Binds
    abstract fun bindReportPresentationToDomainMapper(base: ReportPresentationToDomainMapper.Base) : ReportPresentationToDomainMapper
}