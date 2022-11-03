package com.earl.innovation_systems_minitv.presentation

import android.content.Context
import androidx.lifecycle.*
import com.earl.innovation_systems_minitv.domain.Interactor
import com.earl.innovation_systems_minitv.presentation.mappers.ReportPresentationToDomainMapper
import com.earl.innovation_systems_minitv.presentation.models.ReportPresentation
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.StringReader
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: Interactor,
    private val reportPresentationToDomainMapper: ReportPresentationToDomainMapper
) : ViewModel() {

    private val videoListLiveData = MutableLiveData<List<com.earl.innovation_systems_minitv.presentation.models.Video>>()

    fun parseJson(context: Context) {
        val json = context.assets.open(MEDIALIST_FILE)
            .bufferedReader()
            .use { it.readText() }
        val stringReader = StringReader(json)
        val gson = Gson()
        val enums: List<com.earl.innovation_systems_minitv.presentation.models.Video> = gson.fromJson(
            stringReader,
            Array<com.earl.innovation_systems_minitv.presentation.models.Video>::class.java
        ).toList()
        videoListLiveData.value = enums
    }

    fun observeVideoListLiveData(owner: LifecycleOwner, observer: Observer<List<com.earl.innovation_systems_minitv.presentation.models.Video>>) {
        videoListLiveData.observe(owner, observer)
    }

    fun insertNewReport(report: ReportPresentation) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.insertNewReport(reportPresentationToDomainMapper.map(report))
        }
    }

    companion object {

        private const val MEDIALIST_FILE = "videos/medialist.json"
    }
}