package com.android.nouscodetest.view.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.nouscodetest.model.ListRepository
import com.android.nouscodetest.model.response.DataResponse
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import org.json.JSONArray
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.android.nouscodetest.model.response.Item
import com.android.nouscodetest.view.BaseViewModel


class ListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

       fun fetchList(context: Context) {
           dataLoading.value = true
        val data = ListRepository.getInstance().getAssetJsonData(context)
        val gson = Gson()
        val listPersonType = object : TypeToken<DataResponse>() {}.type
        val persons: DataResponse = gson.fromJson(data, listPersonType)
        repoListLive.value=persons.items
           if (repoListLive.value!=null)
           {
               dataLoading.value = false
           }


    }
}