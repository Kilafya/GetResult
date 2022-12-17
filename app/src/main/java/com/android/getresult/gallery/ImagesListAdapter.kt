package com.android.getresult.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.android.getresult.databinding.ItemPhotoBinding

class ImagesListAdapter: ListAdapter<Photo, ImageViewHolder>(ImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.binding.photo.load(currentList[position].uri)
    }

    fun updateList(newPhoto: Photo) {
        submitList(currentList + newPhoto)
    }
}