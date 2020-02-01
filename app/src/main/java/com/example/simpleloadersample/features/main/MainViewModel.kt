package com.example.simpleloadersample.features.main

import androidx.lifecycle.MutableLiveData
import com.example.simpleloadersample.features.base.BaseViewModel
import com.example.simpleloadersample.data.repository.ImageRepository
import com.example.simpleloadersample.model.ImageModel
import com.example.simpleloadersample.util.schedulers.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MainViewModel @Inject constructor(schedulerProvider: SchedulerProvider, private val imageRepository: ImageRepository
) : BaseViewModel(schedulerProvider) {

    val imageList = MutableLiveData<List<ImageModel>>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()

    }

    fun loadImageList() {
        compositeDisposable.add(imageRepository.getImages()
                .compose(applySchedulers())
                .subscribe({
                    imageList.value = it
                }, { it.printStackTrace() })
        )
    }
}