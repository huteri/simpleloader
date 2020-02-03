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
    val list = mutableListOf<ImageModel>()
    var listOffset = 10

    val imageListLiveData = MutableLiveData<List<ImageModel>>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()

    }

    fun loadImageList() {
        compositeDisposable.add(imageRepository.getImages()
                .compose(applySchedulers())
                .subscribe({
                    list.clear()
                    list.addAll(it)
                    listOffset = 10

                    imageListLiveData.value = list.take(listOffset)

                }, { it.printStackTrace() })
        )
    }

    fun loadMore() {
        if(listOffset < list.size) {
            listOffset += 10
            imageListLiveData.value = list.take(listOffset)
        }
    }

}