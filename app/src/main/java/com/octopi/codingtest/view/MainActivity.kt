package com.octopi.codingtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.octopi.codingtest.databinding.ActivityMainBinding
import com.octopi.codingtest.other.GridSpacingItemDecoration
import com.octopi.codingtest.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:AlbumAdapter
    private val mainViewModel:MainViewModel by lazy { MainViewModel() }
    private var albumId:Int = 98

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        getAlbumData()
        initializeListeners()
        initializeObservers()
    }

    private fun initializeObservers() {
        mainViewModel.albumLiveData.observe(this, {

            if (it != null && it.size != 0){
                binding.albumRv.visibility = View.VISIBLE
                binding.textNoAlbumFound.visibility = View.GONE

                adapter = AlbumAdapter(this, it)
                binding.albumRv.adapter = adapter

                Log.d("test_main", "onCreate: size: ${it.size}")

            }else{
                binding.albumRv.visibility = View.GONE
                binding.textNoAlbumFound.visibility = View.VISIBLE
            }

        })
    }

    private fun initializeListeners() {
        binding.textNextAlbum.setOnClickListener {
            albumId = albumId.plus(1)
            getAlbumData()
        }

        binding.textPrevAlbum.setOnClickListener {
            if (albumId > 1) {
                albumId = albumId.minus(1)
                getAlbumData()
            }
        }
    }

    private fun getAlbumData() {
        mainViewModel.getAlbumData(albumId,this)
    }

    private fun initRecycler() {
        binding.albumRv.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this,2)
        binding.albumRv.layoutManager = gridLayoutManager
        binding.albumRv.addItemDecoration(GridSpacingItemDecoration(2,50,true))

    }
}