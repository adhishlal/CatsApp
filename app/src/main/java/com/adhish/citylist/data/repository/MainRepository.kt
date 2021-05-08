package com.adhish.citylist.data.repository

import com.adhish.citylist.data.api.ApiHelper
import com.adhish.citylist.data.model.GeoNames
import io.reactivex.Observable

class MainRepository(private val apiHelper: ApiHelper) {

    fun getCountries(
        name: String
    ): Observable<List<GeoNames>> =
        apiHelper.getCountries(name)

}
