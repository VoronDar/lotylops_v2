package com.astery.lotylops.repository.localDataStorage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.astery.lotylops.model.entities.*
import com.astery.lotylops.repository.localDataStorage.dao.CardDao
import com.astery.lotylops.repository.localDataStorage.dao.SentenceDao

@Database(entities = [VocabularyCard::class, PhraseologyCard::class, GrammarCard::class, ExceptionCard::class,
                     PhoneticsCard::class, CultureCard::class, Sentence.Example::class, Sentence.Train::class, SelectTrain::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getCardDao(): CardDao
    abstract fun getSentenceDao(): SentenceDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, AppDatabase::class.java, "databa")
                    .fallbackToDestructiveMigration()
                    .build()
                instance
            }
        }
    }
}