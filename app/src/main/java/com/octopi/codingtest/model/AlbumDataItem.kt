package com.octopi.codingtest.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AlbumDataItem(
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) : Serializable