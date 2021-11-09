package com.astery.lotylops.ui.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astery.lotylops.R
import com.astery.lotylops.databinding.ActivityBaseBinding
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import com.astery.lotylops.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class BaseActivity : AppCompatActivity(), OnInitListener {



    private val viewModel: BaseViewModel by viewModels()
    private var _binding:ActivityBaseBinding? = null
    private val binding get() = _binding!!


    var repeatTTS: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.inflate(layoutInflater,
            R.layout.activity_base, null, false)
        setContentView(binding.root)

        repeatTTS = TextToSpeech(this, this)

        viewModel.prepare()

        /*

        daily routine

        Ruler.setTodayTables(this)

         */
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result: Int = repeatTTS!!.setLanguage(Locale.UK)

            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Timber.e("TTS don't supported")
            }
        }
    }

    override fun onDestroy() {
        if (repeatTTS != null) {
            repeatTTS!!.stop()
            repeatTTS!!.shutdown()
        }

        binding.unbind()
        _binding = null

        super.onDestroy()
    }

}