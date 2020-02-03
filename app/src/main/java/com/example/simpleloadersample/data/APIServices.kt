package com.example.simpleloadersample.data

import com.example.simpleloadersample.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET


interface APIServices {

    @GET("/raw/icMKhEi9")
    fun getImages() : Single<List<ImageResponse>>

}