package com.adhish.catsapp.data.repository

import com.adhish.catsapp.data.api.ApiHelper
import com.adhish.catsapp.data.model.CatsResponse
import io.reactivex.Observable

class MainRepository(private val apiHelper: ApiHelper) {

    fun getCats(
        page: Int, limit: Int
    ): Observable<List<CatsResponse>> =
        apiHelper.getCats(page, limit)

}
