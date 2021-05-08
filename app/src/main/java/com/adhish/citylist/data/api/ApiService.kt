package com.adhish.citylist.data.api

import com.adhish.citylist.data.model.GeoNames
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("name_startsWith={name}&maxRows=10&username=keep_truckin\n")
    fun getCountries(
        @Path("name") name: String
    ): Observable<List<GeoNames>>

}
