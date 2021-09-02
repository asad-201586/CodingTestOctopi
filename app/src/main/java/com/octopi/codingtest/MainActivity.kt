package com.octopi.codingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.octopi.codingtest.databinding.ActivityMainBinding
import com.octopi.codingtest.viewHolder.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainViewModel = MainViewModel(this,"1")
        mainViewModel.getAlbumData()

        mainViewModel.albumLiveData.observe(this, Observer {
            Log.d("data_list", "onCreate: size: ${it.size}")
            Log.d("data_list", "onCreate: title: ${it[0].title}")
            Log.d("data_list", "onCreate: url: ${it[0].url}")
            Log.d("data_list", "onCreate: id: ${it[0].id}")
        })
    }
}