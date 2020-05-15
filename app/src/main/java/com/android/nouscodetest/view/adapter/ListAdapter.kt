package com.ankit.trendinggit.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.nouscodetest.databinding.ViewListItemBinding
import com.android.nouscodetest.model.response.Item
import com.android.nouscodetest.view.ui.viewmodel.ListViewModel
import com.ankit.trendinggit.view.adapter.viewHolders.ListViewHolder


class ListAdapter(private val repoListViewModel: ListViewModel) : RecyclerView.Adapter<ListViewHolder>() {
    var repoList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewListItemBinding.inflate(inflater, parent, false)
        return ListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    /**
     * Updates the list
     * */
    fun updateList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}