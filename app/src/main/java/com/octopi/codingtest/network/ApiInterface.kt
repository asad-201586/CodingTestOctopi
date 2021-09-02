package com.octopi.codingtest.network

import com.octopi.codingtest.model.AlbumData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun allAlbums(
        @Url url:String
    ): Call<AlbumData>
}