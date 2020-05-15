package com.android.nouscodetest.model

import android.content.Context
import android.util.Log
import java.io.IOException

class ListRepository {

    // GET JsonData from assets folder
    fun getAssetJsonData(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("items_v2.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    companion object {
        private var INSTANCE: ListRepository? = null
        fun getInstance() = INSTANCE
                ?: ListRepository().also {
                    INSTANCE = it
                }
    }
}