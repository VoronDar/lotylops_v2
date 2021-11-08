package com.astery.lotylops.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astery.lotylops.R
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private val viewModel:BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        viewModel.start()
    }
}


@HiltViewModel
class BaseViewModel @Inject constructor():ViewModel(){
    @Inject lateinit var database:AppDatabase
    fun start() {
        viewModelScope.launch {
            /*
            Timber.i("STARRTED")
            Timber.i("start")
            database.getCardDao().addCard(
                VocabularyCard(
                    "1", "asasd", 1, 1, 1, "asdasd", true,
                    "asdasd", "asdasd", null, null, null, null, null, , "asdasd", -1, -1
                )
            )
            Timber.i(database.getCardDao().getAllVocabularyCards()[0].toString())

             */
        }
    }
}