package com.moviz.app.example.retrofit

import com.google.gson.annotations.SerializedName

data class Movie(
    val rank :  Int,
    val title : String,
    val description :  String,
    val image  : String,
    @SerializedName("big_image")
    val bigImage  : String,
    val genre : ArrayList<String>,
    val thumbnail : String,
    val rating : String,
    val id : String,
    val year  : Int,
    @SerializedName("imdbid")
    val imdbId  :String,
    @SerializedName("imdb_link")
    val imdbLink  : String
)
