package com.example.simpleloader.loader

import android.content.Context
import com.example.simpleloader.Downloader

abstract class BaseLoader(protected val context: Context, protected val url: String) {
    protected val downloader = Downloader.getInstance()
}