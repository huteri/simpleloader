package com.example.simpleloader

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.InputStream
import java.util.concurrent.Executors


class Downloader {

    private var cache = MemoryCache(100000000)

    private var executorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    private val client = OkHttpClient()

    companion object {

        private var INSTANCE: Downloader? = null

        @Synchronized
        fun getInstance(): Downloader {
            return INSTANCE
                ?: Downloader().also {
                INSTANCE = it
            }
        }

    }

    fun get(url: String, listener: Listener) {

        if(cache.get(url) != null) {
            listener.onSuccess(cache.get(url))
            return
        }

        executorService.submit {

            var file = downloadFile(url)
            cache.put(url, file?.readBytes())

            listener.onSuccess(cache.get(url))
        }

    }


    private fun downloadFile(url: String): InputStream? {
        val request = Request.Builder()
            .url(url)
            .build()

        var response = client.newCall(request).execute()

        return response.body?.byteStream()
    }

}

interface Listener {
    fun onSuccess(data: ByteArray?)
}