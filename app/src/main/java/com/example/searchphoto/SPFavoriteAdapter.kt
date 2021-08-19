package com.example.searchphoto

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.core.model.consultation.Result as ResultPhotos
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.searchphoto.databinding.PhotoItemBinding
import com.squareup.picasso.Picasso

class SPFavoriteAdapter :
    RecyclerView.Adapter<SPFavoriteAdapter.SPFavoriteViewHolder>() {

    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<ResultPhotos>() {

        override fun areItemsTheSame(oldItem: ResultPhotos, newItem: ResultPhotos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultPhotos, newItem: ResultPhotos): Boolean {
            return oldItem == newItem
        }

    }

    private val listDiffer = AsyncListDiffer(this, diffUtilItemCallback)

    private lateinit var binding: PhotoItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SPFavoriteViewHolder {
        binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SPFavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SPFavoriteViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun submitList(list: List<ResultPhotos>) {
        listDiffer.submitList(list)
    }

    class SPFavoriteViewHolder
    constructor(
        private val binding: PhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultPhotos) {

            binding.textTitlePhoto.text = item.description ?: item.alt_description
            binding.favoritePhoto.isVisible = false

            Picasso.get().load(item.urlThumb)
                .placeholder(R.drawable.picture_placeholder)
                .error(R.drawable.picture_placeholder)
                .into(binding.imagePhoto)

            binding.root.setOnClickListener {

            }
        }
    }

}