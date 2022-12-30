package com.idat.edu.pe.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idat.edu.pe.R
import com.idat.edu.pe.model.JsonPlaceholderPhoto

class JsonPlaceholderPhotosAdapter : RecyclerView.Adapter<JsonPlaceholderPhotosAdapter.ViewHolder> {

    var jsonplaceholderPhotosList: List<JsonPlaceholderPhoto>
    var context: Context

    constructor(context: Context, jsonplaceholderPhotosList: List<JsonPlaceholderPhoto>) {
        this.context = context
        this.jsonplaceholderPhotosList = jsonplaceholderPhotosList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jsonplaceholderphotos_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txvAlbumId.text = "AlbumId: ${jsonplaceholderPhotosList[position].albumId}"
        holder.txvIdPhoto.text = "AlbumId: ${jsonplaceholderPhotosList[position].id}"
        holder.txvTitlePhoto.text = "AlbumId: ${jsonplaceholderPhotosList[position].title}"

        Glide.with(context)
            .asDrawable()
            .load(jsonplaceholderPhotosList[position].thumbnailUrl)
            .into(holder.imvPhoto)
    }

    override fun getItemCount(): Int {
        return jsonplaceholderPhotosList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvAlbumId: TextView
        val txvIdPhoto: TextView
        val txvTitlePhoto: TextView
        val imvPhoto: ImageView

        init {
            txvAlbumId = itemView.findViewById(R.id.txvAlbumId)
            txvIdPhoto = itemView.findViewById(R.id.txvIdPhoto)
            txvTitlePhoto = itemView.findViewById(R.id.txvTitlePhoto)
            imvPhoto = itemView.findViewById(R.id.imvPhoto)
        }
    }
}