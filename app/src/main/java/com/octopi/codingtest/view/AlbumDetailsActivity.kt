package com.octopi.codingtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.octopi.codingtest.R
import com.octopi.codingtest.databinding.ActivityAlbumDetailsBinding
import com.octopi.codingtest.model.AlbumDataItem
import com.squareup.picasso.Picasso

class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumDetailsBinding
    private var data: AlbumDataItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (intent.hasExtra("data")) {
            data = intent.getSerializableExtra("data") as AlbumDataItem
        }
        setData()

    }

    private fun setData() {
        binding.textAlbumId.text = data?.albumId.toString()
        binding.textId.text = data?.id.toString()
        binding.textTitle.text = data?.title.toString()

        Picasso.get().load(data?.url).fit().centerCrop()
            .placeholder(R.drawable.octopi_logo)
            .into(binding.imageAlbum)

    }
}