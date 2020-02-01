package com.example.simpleloader

import android.content.Context

class SimpleLoader(private val context: Context) {

    companion object {
        private var INSTANCE: SimpleLoader? = null

        @Synchronized
        fun with(context: Context): SimpleLoader {

            return INSTANCE
                ?: SimpleLoader(context).also {
                INSTANCE = it
            }
        }
    }

    fun get(url: String): RequestBuilder {
        return RequestBuilder(context, url)
    }

}