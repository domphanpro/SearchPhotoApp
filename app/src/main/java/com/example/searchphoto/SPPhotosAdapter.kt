package com.example.searchphoto

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.core.model.consultation.Result as ResultPhotos
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.searchphoto.databinding.PhotoItemBinding
import com.squareup.picasso.Picasso

class SPPhotosAdapter :
    RecyclerView.Adapter<SPPhotosAdapter.SPPhotosViewHolder>() {

    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<ResultPhotos>() {

        //pk is the primary key for the data class.
        //replace with any unique identifier of your specific data class.
        override fun areItemsTheSame(oldItem: ResultPhotos, newItem: ResultPhotos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultPhotos, newItem: ResultPhotos): Boolean {
            return oldItem == newItem
        }

    }

    private val listDiffer = AsyncListDiffer(this, diffUtilItemCallback)

    private lateinit var binding: PhotoItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SPPhotosViewHolder {
        binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SPPhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SPPhotosViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun submitList(list: List<ResultPhotos>) {
        listDiffer.submitList(list)
    }

    class SPPhotosViewHolder
    constructor(
        private val binding: PhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultPhotos) {

            binding.textTitlePhoto.text = item.description ?: item.alt_description

            Picasso.get().load(item.urls.thumb)
                .placeholder(R.drawable.picture_placeholder)
                .error(R.drawable.picture_placeholder)
                .into(binding.imagePhoto)

            //Custom onClick for whole item onClick
            binding.root.setOnClickListener {

            }
        }
    }

}