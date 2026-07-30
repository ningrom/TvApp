package com.ayuk.tvapp.data

import com.ayuk.tvapp.data.api.TvMazeApiService

class Repository(
    private val api: TvMazeApiService
) {

    suspend fun getShows() = api.getShows()

    suspend fun getShowDetail(id: Int) = api.getShowDetail(id)
}

