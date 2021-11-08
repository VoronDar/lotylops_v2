package com.astery.lotylops.application

import android.content.Context
import com.astery.lotylops.repository.localDataStorage.dao.CardDao
import com.astery.lotylops.repository.localDataStorage.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase.getDatabase(context)
    }
    @Provides
    fun provideCardDao(appDatabase: AppDatabase): CardDao {
        return appDatabase.getCardDao()
    }
}