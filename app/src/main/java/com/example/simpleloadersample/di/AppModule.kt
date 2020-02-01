package com.example.simpleloadersample.di

import com.example.simpleloadersample.data.APIServices
import com.example.simpleloadersample.data.repository.ImageRepository
import com.example.simpleloadersample.data.repository.ImageRepositoryImpl
import com.example.simpleloadersample.util.schedulers.DefaultSchedulerProvider
import com.example.simpleloadersample.util.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(): APIServices {
        return Retrofit.Builder()
            .baseUrl("https://pastebin.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(APIServices::class.java)
    }

    @Singleton
    @Provides
    fun provideImageRepository(apiService: APIServices): ImageRepository {
        return ImageRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideSchedulerProvider() : SchedulerProvider {
        return DefaultSchedulerProvider()
    }

}