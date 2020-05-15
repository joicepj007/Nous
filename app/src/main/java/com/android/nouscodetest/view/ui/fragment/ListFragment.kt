package com.android.nouscodetest.view.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.nouscodetest.databinding.FragmentListBinding
import com.android.nouscodetest.view.ui.viewmodel.ListViewModel
import com.ankit.trendinggit.view.adapter.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentListBinding

    //adaptor to show list of items
    private lateinit var adapter: ListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@ListFragment).get(ListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchList(requireContext())
        setupObservers()
        setupAdapter()
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })

    }
    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = ListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            repo_list_rv.adapter = adapter
        }
    }




}
