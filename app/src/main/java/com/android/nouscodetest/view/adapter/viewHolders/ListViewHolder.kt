package com.ankit.trendinggit.view.adapter.viewHolders

import android.app.Activity
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.nouscodetest.BR
import com.android.nouscodetest.R
import com.android.nouscodetest.model.response.Item
import com.android.nouscodetest.view.ui.viewmodel.ListViewModel

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_list_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListViewHolder constructor(private val dataBinding: ViewDataBinding, private val ListViewModel: ListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
        Picasso.get().load(itemData.imageUrl).into(avatarImage);
        itemView.onClick {
            val bundle = bundleOf("url" to itemData.imageUrl,"title" to itemData.title,"description" to itemData.description)
            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}