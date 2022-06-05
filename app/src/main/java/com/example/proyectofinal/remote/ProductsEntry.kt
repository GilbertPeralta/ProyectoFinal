package com.example.proyectofinal.remote

import com.google.gson.annotations.SerializedName


data class ProductsEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("rating")
    val rating: RatingEntry
)

data class RatingEntry(
    @SerializedName("rate")
    val rate: Float
)

