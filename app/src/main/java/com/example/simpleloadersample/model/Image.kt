package com.example.simpleloadersample.model

import com.google.gson.annotations.SerializedName


data class ImageResponse(
    private val id: String,
    private val urls: ImageUrls,
    private val user: User,
    private val likes: Int
) : ImageModel {
    override fun getLikes(): Int {
        return likes
    }

    override fun getUserName(): String {
        return user.name
    }

    override fun getUserImage(): String {
        return user.profileImage.large
    }

    override fun getUrl(): String {
        return urls.full
    }

    override fun getId(): String = id
}


data class ImageUrls(
    val raw: String,
    val full: String
)

data class User (
    var name: String,
    @SerializedName("profile_image")
    var profileImage: UserProfileImage
)

data class UserProfileImage (
    var large: String
)

interface ImageModel {
    fun getId(): String
    fun getUrl(): String
    fun getUserName(): String
    fun getUserImage(): String
    fun getLikes(): Int
}