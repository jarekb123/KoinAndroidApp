package com.butajlo.koinandroidapp.screen.profile.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.butajlo.koinandroidapp.databinding.ItemPostBinding
import com.butajlo.koinandroidapp.sharedbindings.CardPostBindingModel
import com.butajlo.koinandroidapp.ui.binding

class MyPostsAdapter : RecyclerView.Adapter<MyPostsAdapter.ViewHolder>() {

    private val posts = mutableListOf<CardPostBindingModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPostBinding.inflate(inflater, parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size

    fun setPosts(newPosts: List<CardPostBindingModel>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }


    class ViewHolder(binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding: ItemPostBinding? by binding()

        fun bind(item: CardPostBindingModel) {
            binding?.apply {
                post = item
                executePendingBindings()
            }
        }

    }
}