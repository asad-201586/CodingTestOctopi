package com.octopi.codingtest.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.octopi.codingtest.R
import com.octopi.codingtest.databinding.ItemAlbumBinding
import com.octopi.codingtest.model.AlbumData
import com.octopi.codingtest.model.AlbumDataItem
import com.squareup.picasso.Picasso


class AlbumAdapter(
    private val context:Context,
    private val albumData: AlbumData
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {


    class AlbumViewHolder(binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root){
        var imageAlbum = binding.imageAlbum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ItemAlbumBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val model = albumData[position]
        loadImage(holder.imageAlbum,model)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AlbumDetailsActivity::class.java)
            intent.putExtra("data", model)
            context.startActivity(intent)

        }
    }

    private fun loadImage(imageAlbum: ImageView, model: AlbumDataItem) {
        Picasso.get().load(model.url).fit().centerCrop()
            .placeholder(R.drawable.octopi_logo)
            .into(imageAlbum)
    }

    override fun getItemCount(): Int {
        if (albumData.isNotEmpty()) return albumData.size
        return 0
    }

}