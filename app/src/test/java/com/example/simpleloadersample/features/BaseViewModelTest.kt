package com.example.simpleloadersample.features

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.simpleloadersample.data.repository.ImageRepository
import com.example.simpleloadersample.util.schedulers.ImmediateSchedulerProvider
import com.example.simpleloadersample.util.schedulers.SchedulerProvider
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

open class BaseViewModelTest {



    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    protected lateinit var imageRepository: ImageRepository

    protected val scheduler: SchedulerProvider
        get() = ImmediateSchedulerProvider()


    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

}