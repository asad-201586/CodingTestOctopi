package com.octopi.codingtest.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.octopi.codingtest.model.AlbumData
import com.octopi.codingtest.other.CustomLoadingDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrieveAlbumData(
    private val context: Context,
    private val albumId: String,
    var callback: AlbumCallback
) {
    private val TAG: String? = this.javaClass.name
    var loadingDialog: CustomLoadingDialog = CustomLoadingDialog(context)

    fun getAlbums(){
        loadingDialog.start()
        val call: Call<AlbumData> = RetrofitClient
            .getInstance()
            ?.getApi()
            ?.AllAlbums("/photos?albumId=$albumId")!!

        call.enqueue(object : Callback<AlbumData?> {
            override fun onResponse(
                call: Call<AlbumData?>,
                response: Response<AlbumData?>
            ) {
                loadingDialog.dismiss()
                if (response.isSuccessful) {
                    if (response.body() != null && response.body()!!.size != 0)
                        callback.albumListCallback(response.body()!!)
                    Log.d(TAG, "album data found")
                } else {
                    Log.d(TAG, "album data not found")
                }
            }

            override fun onFailure(call: Call<AlbumData?>, t: Throwable) {
                Log.d(TAG, "onFailure: album data response failure: " + t.message)
                loadingDialog.dismiss()
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}