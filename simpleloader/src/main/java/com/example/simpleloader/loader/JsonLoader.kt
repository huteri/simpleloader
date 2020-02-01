package com.example.simpleloader.loader

import android.content.Context
import com.example.simpleloader.Listener


class JsonLoader(context: Context, url: String) : BaseLoader(context, url){

    fun asString(listener: JsonLoaderListener) {

        downloader.get(url, object : Listener {
            override fun onSuccess(data: ByteArray?) {
                listener.onSuccess(String(data ?: ByteArray(0)))
            }

        })
    }
}

interface JsonLoaderListener {
    fun onSuccess(json: String)
}