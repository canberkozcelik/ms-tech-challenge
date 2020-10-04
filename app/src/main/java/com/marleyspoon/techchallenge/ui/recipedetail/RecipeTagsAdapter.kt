package com.marleyspoon.techchallenge.ui.recipedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marleyspoon.techchallenge.R
import com.marleyspoon.techchallenge.databinding.ListItemTagBinding

class RecipeTagsAdapter(private val tagList: List<String>) :
    RecyclerView.Adapter<RecipeTagsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemTagBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_tag,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tag = tagList[position]
        holder.binding.tag = tag
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    inner class ViewHolder(val binding: ListItemTagBinding) : RecyclerView.ViewHolder(binding.root)
}
