package com.earl.innovation_systems_minitv.presentation

import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.earl.innovation_systems_minitv.databinding.ActivityMainBinding
import com.earl.innovation_systems_minitv.presentation.models.ReportPresentation
import com.earl.innovation_systems_minitv.presentation.models.Video
import dagger.hilt.android.AndroidEntryPoint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var surfaceView: View
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var surfaceHolder: SurfaceHolder
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        surfaceView = binding.surfaceView
        surfaceHolder = binding.surfaceView.holder
        surfaceHolder.addCallback(this)
    }

    private fun currentTime(): String {
        val currentDate = Date()
        val timeFormat: DateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return timeFormat.format(currentDate)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {

        mediaPlayer = MediaPlayer()
        mediaPlayer.setDisplay(surfaceHolder)
        var list: List<Video> = emptyList()
        viewModel.parseJson(this)
        viewModel.observeVideoListLiveData(this) {
            list = it
        }

        var videoPlayingIndex = 0
        try {
            val video = list[videoPlayingIndex].VideoIdentifier
            val afd = assets.openFd("videos/$video")
            mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            mediaPlayer.prepare()
            mediaPlayer.setOnPreparedListener(this)

            val report = ReportPresentation(
                list[videoPlayingIndex].VideoId,
                list[videoPlayingIndex].VideoIdentifier,
                currentTime()
            )
            viewModel.insertNewReport(report)

            mediaPlayer.setOnCompletionListener {

                val report = ReportPresentation(
                    list[videoPlayingIndex].VideoId,
                    list[videoPlayingIndex].VideoIdentifier,
                    currentTime()
                )
                viewModel.insertNewReport(report)

                if (videoPlayingIndex < list.size - 1) {
                    videoPlayingIndex += 1
                    val videoName = list[videoPlayingIndex].VideoIdentifier
                    val afd = assets.openFd("videos/$videoName")
                    mediaPlayer.reset()
                    mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                    mediaPlayer.prepare()
                    mediaPlayer.setOnPreparedListener(this)
                } else {
                    mediaPlayer.stop()
                    Toast.makeText(this, "that's all...", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer.start()
    }
}
