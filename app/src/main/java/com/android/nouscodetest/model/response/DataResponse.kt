package com.android.nouscodetest.model.response

data class DataResponse(
        val items: List<Item>
)

data class Item(
        val id: Int,
        val title: String,
        val description: String,
        val imageUrl: String
)

