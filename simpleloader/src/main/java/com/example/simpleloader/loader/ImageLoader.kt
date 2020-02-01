package com.example.simpleloader.loader

import android.content.Context
import android.widget.ImageView
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.example.simpleloader.Listener

class ImageLoader(context: Context, url: String) : BaseLoader(context, url) {

    private val uiHandler: Handler = Handler(Looper.getMainLooper())

    fun into(imageView: ImageView) {
        downloader.get(url, object : Listener {
            override fun onSuccess(data: ByteArray?) {
                uiHandler.post {
                    Glide.with(context).load(data).into(imageView)
                }
            }

        })
    }

}