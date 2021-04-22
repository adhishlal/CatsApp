package com.adhish.catsapp.data.api

import com.adhish.catsapp.data.model.CatsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("images/search")
    fun getCats(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Observable<List<CatsResponse>>

}
