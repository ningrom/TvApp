package com.ayuk.tvapp.data.api
import com.ayuk.tvapp.data.model.Tvshow
import retrofit2.http.GET
import retrofit2.http.Path

interface TvMazeApiService {

    @GET("shows")
    suspend fun getShows(): List<Tvshow>

    @GET("shows/{id}")
    suspend fun getShowDetail(@Path("id") id: Int): Tvshow
}