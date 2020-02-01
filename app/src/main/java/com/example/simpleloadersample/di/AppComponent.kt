package com.example.simpleloadersample.di

import android.content.Context
import com.example.simpleloadersample.App
import com.example.simpleloadersample.features.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
    fun inject(app: App)
    fun inject(app: MainActivity)
}