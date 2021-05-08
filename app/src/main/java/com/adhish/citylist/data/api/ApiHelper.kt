package com.adhish.citylist.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getCountries(name: String) = apiService.getCountries(name)

}
