package com.example.simpleloadersample.features.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.simpleloadersample.features.BaseViewModelTest
import com.example.simpleloadersample.model.ImageModel
import io.reactivex.Observable
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MainViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: MainViewModel

    override fun setUp() {
        super.setUp()
        viewModel = MainViewModel(scheduler, imageRepository)
    }

    @Test
    fun `load image list will return the first PER_PAGE items`() {

        val image = Mockito.mock(ImageModel::class.java)
        Mockito.`when`(imageRepository.getImages())
            .thenReturn(Observable.just(listOf(image, image, image, image, image, image)))

        viewModel.imageListLiveData.observeForever { }

        viewModel.loadImageList()

        assertEquals(image, viewModel.imageListLiveData.value?.first())
        assertEquals(MainViewModel.PER_PAGE, viewModel.imageListLiveData.value?.size)
    }


    @Test
    fun `load more will return 2 times of PER_PAGE items`() {
        val image = Mockito.mock(ImageModel::class.java)
        Mockito.`when`(imageRepository.getImages()).thenReturn(
            Observable.just(
                listOf(
                    image,
                    image,
                    image,
                    image,
                    image,
                    image,
                    image,
                    image,
                    image,
                    image,
                    image
                )
            )
        )
        viewModel.imageListLiveData.observeForever { }

        viewModel.loadImageList()

        viewModel.loadMore()

        assertEquals(MainViewModel.PER_PAGE * 2, viewModel.imageListLiveData.value?.size)

    }

}