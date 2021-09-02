package com.octopi.codingtest.viewHolder


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.octopi.codingtest.model.AlbumData
import com.octopi.codingtest.network.AlbumCallback
import com.octopi.codingtest.network.RetrieveAlbumData

class MainViewModel(
    private val context: Context,
    private var albumId:String
    ) :  ViewModel(){

    private val TAG: String? = this.javaClass.name
    private var albumLiveDataObject = MutableLiveData<AlbumData>()
    val albumLiveData : LiveData<AlbumData> get() = albumLiveDataObject

    fun getAlbumData(){
        val retrieveAlbumData = RetrieveAlbumData(context,albumId,object : AlbumCallback{
            override fun albumListCallback(albumData: AlbumData) {
                albumLiveDataObject.value = albumData
            }
        })
        retrieveAlbumData.getAlbums()
    }
}