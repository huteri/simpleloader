package com.example.simpleloadersample.features.base

import androidx.lifecycle.ViewModel
import com.example.simpleloadersample.util.schedulers.SchedulerProvider
import io.reactivex.ObservableTransformer

abstract class BaseViewModel(val scheduler: SchedulerProvider) : ViewModel() {

    protected fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
        }
    }


}
