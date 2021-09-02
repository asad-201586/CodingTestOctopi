package com.octopi.codingtest.viewModel


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.octopi.codingtest.model.AlbumData
import com.octopi.codingtest.network.AlbumCallback
import com.octopi.codingtest.network.RetrieveAlbumData

class MainViewModel :  ViewModel(){

    private val tag: String? = this.javaClass.name
    var albumLiveDataObject = MutableLiveData<AlbumData>()
    val albumLiveData : LiveData<AlbumData> get() = albumLiveDataObject

    fun getAlbumData(albumId:Int,context: Context){
        Log.d(tag, "albumListCallback: id: $albumId")
        val retrieveAlbumData = RetrieveAlbumData(context,albumId.toString(),object : AlbumCallback{
            override fun albumListCallback(albumData: AlbumData?) {

                albumLiveDataObject.value = albumData

            }
        })
        retrieveAlbumData.getAlbums()
    }
}