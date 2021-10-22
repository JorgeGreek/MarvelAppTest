package com.test.marvelapptest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.CharacterResult
import com.test.marvelapptest.R
import com.test.marvelapptest.ui.common.loadImage
import com.test.marvelapptest.databinding.CharacterItemBinding

class CharacterListAdapter(private val clientsClickListener: (CharacterResult) -> Unit) :
    PagingDataAdapter<CharacterResult, CharacterListAdapter.ViewHolder>(DiffCallback) {

    init {
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CharacterResult>() {
        override fun areItemsTheSame(oldItem: CharacterResult, newItem: CharacterResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CharacterResult, newItem: CharacterResult) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val client = getItem(position)
        if (client != null) {
            holder.bind(client)
        }
        holder.itemView.setOnClickListener { clientsClickListener(client!!) }
    }


    class ViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(mediaAccount: CharacterResult) {
            binding.heroText.text = mediaAccount.name
            if (mediaAccount.thumbnail.path.contains("not_available")) {
                binding.heroImage.setImageResource(R.drawable.marvel_error)
            } else {
                binding.heroImage.loadImage(
                    mediaAccount.thumbnail?.path,
                    mediaAccount.thumbnail?.extension
                )
            }
        }

    }
}
