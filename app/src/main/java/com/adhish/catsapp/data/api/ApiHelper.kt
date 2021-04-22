package com.adhish.catsapp.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getCats(page: Int, limit: Int) = apiService.getCats(page, limit)

}
