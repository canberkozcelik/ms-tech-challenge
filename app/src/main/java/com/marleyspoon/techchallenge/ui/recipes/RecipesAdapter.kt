package com.marleyspoon.techchallenge.ui.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marleyspoon.techchallenge.R
import com.marleyspoon.techchallenge.common.extension.notNull
import com.marleyspoon.techchallenge.common.extension.setSafeOnClickListener
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import com.marleyspoon.techchallenge.databinding.ListItemRecipeBinding

class RecipesAdapter(private val onRecipeItemSelectedListener: OnRecipeItemSelectedListener) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {
    private var itemList: List<RecipesResponse.Item?> = arrayListOf()
    private var assetList: List<RecipesResponse.Includes.Asset?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemRecipeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_recipe,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        item ?: return
        holder.bind(item, onRecipeItemSelectedListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateList(
        items: List<RecipesResponse.Item?>,
        asset: List<RecipesResponse.Includes.Asset?>
    ) {
        this.itemList = items
        this.assetList = asset
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ListItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: RecipesResponse.Item,
            itemSelectedListener: OnRecipeItemSelectedListener,
        ) {
            binding.item = item
            assetList.map { asset ->
                if (asset?.sys?.id == item.fields?.photo?.sys?.id) {
                    asset?.fields?.file?.url.notNull {
                        binding.imageUrl = String.format("http:%s", it)
                    }
                }
            }
            binding.root.setSafeOnClickListener { itemSelectedListener.itemSelected(item) }
        }
    }

    interface OnRecipeItemSelectedListener {
        fun itemSelected(item: RecipesResponse.Item)
    }
}