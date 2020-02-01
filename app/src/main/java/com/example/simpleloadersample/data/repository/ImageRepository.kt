package com.example.simpleloadersample.data.repository

import com.example.simpleloadersample.data.APIServices
import com.example.simpleloadersample.model.ImageModel
import io.reactivex.Observable


interface ImageRepository {
    fun getImages(): Observable<List<ImageModel>>
}

class ImageRepositoryImpl constructor(val apiServices: APIServices): ImageRepository {

    override fun getImages(): Observable<List<ImageModel>> {
        return apiServices.getImages().toObservable().flatMapIterable<ImageModel> { it }.toList().toObservable()
    }

}