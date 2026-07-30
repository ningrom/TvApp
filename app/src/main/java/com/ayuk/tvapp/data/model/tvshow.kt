package com.ayuk.tvapp.data.model

data class Tvshow(
//    @SeriizedName("id")
    var name: String,
    var id: Int,
    var imageUrl: String?,
    var rating: Rating?
)