package com.example.simpleloader

import android.util.LruCache

interface Cache {

    fun put(url: String, bytes: ByteArray?)
    fun get(url: String): ByteArray?
    fun clear()
}


class MemoryCache (val cacheSize: Int = 0) : Cache {
    private val cache: LruCache<String, ByteArray?>

    init {

        cache = object : LruCache<String, ByteArray?>(cacheSize) {
            override fun sizeOf(key: String?, bytes: ByteArray?): Int {
                return bytes?.size ?: 0
            }
        }
    }


    override fun put(url: String, bytes: ByteArray?) {
        cache.put(url, bytes)

    }

    override fun get(url: String): ByteArray? {
        return cache.get(url)
    }

    override fun clear() {
        cache.evictAll()
    }

}