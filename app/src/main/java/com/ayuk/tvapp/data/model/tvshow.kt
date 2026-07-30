package com.ayuk.tvapp.data.model

data class Tvshow(

    val id: Int,
    val name: String,
    val image: Image?,
    val rating: Rating?,
    val summary: String?,
    val premiered: String?
)