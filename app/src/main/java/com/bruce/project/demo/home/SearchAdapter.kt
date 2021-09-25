package com.bruce.project.demo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bruce.project.demo.databinding.SearchItemBinding
import com.bruce.project.demo.entity.UserItems

class SearchAdapter :
    PagingDataAdapter<UserItems, SearchAdapter.SearchListViewHolder>(REPO_COMPARATOR) {

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        return SearchListViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class SearchListViewHolder(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserItems) = with(binding) {
            ivAvatar.load(item.avatarUrl)
            tvId.text = item.id.toString()
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<UserItems>() {

            override fun areItemsTheSame(oldItem: UserItems, newItem: UserItems): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserItems, newItem: UserItems): Boolean =
                oldItem == newItem
        }
    }
}