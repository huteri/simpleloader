package com.example.simpleloader

import android.content.Context
import android.widget.ImageView
import com.example.simpleloader.loader.ImageLoader
import com.example.simpleloader.loader.JsonLoader

class RequestBuilder(private val context: Context, private val url: String) {

    fun into(imageView: ImageView) {
        asImage().into(imageView)
    }

    fun asImage(): ImageLoader {
        return ImageLoader(context, url)
    }

    fun asJson(): JsonLoader {
        return JsonLoader(context, url)
    }
}