package com.octopi.codingtest.network

import com.octopi.codingtest.model.AlbumData

interface AlbumCallback {
    fun albumListCallback(albumData: AlbumData)
}