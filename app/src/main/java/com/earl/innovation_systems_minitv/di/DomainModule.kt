package com.earl.innovation_systems_minitv.di

import com.earl.innovation_systems_minitv.domain.Interactor
import com.earl.innovation_systems_minitv.domain.mappers.ReportDomainToDataMapper
import com.earl.innovation_systems_minitv.domain.mappers.ReportDomainToPresentationMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindInteractor(base: Interactor.Base) : Interactor

    @Binds
    abstract fun bindReportDomainToPresentationMapper(base: ReportDomainToPresentationMapper.Base) : ReportDomainToPresentationMapper

    @Binds
    abstract fun bindReportDomainToDataMapper(base: ReportDomainToDataMapper.Base) : ReportDomainToDataMapper
}