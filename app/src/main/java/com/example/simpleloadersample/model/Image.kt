package com.example.simpleloadersample.model



data class ImageResponse(
    private val id: String,
    private val urls: ImageUrls
) : ImageModel {

    override fun getUrl(): String {
        return urls.full
    }

    override fun getId(): String = id
}


data class ImageUrls(
    val raw: String,
    val full: String
)

interface ImageModel {
    fun getId(): String
    fun getUrl(): String
}