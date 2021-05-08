package com.adhish.citylist.data.model

data class CountryResponse(
    val geonames: List<GeoNames>? = null,
    val totalResultsCount: Int
)

data class GeoNames(
    val adminCode1: String? = null,
    val lng: String? = null,
    val geonameId: String? = null,
    val toponymName: String? = null,
    val countryId: String? = null,
    val fcl: String? = null,
    val population: String? = null,
    val countryCode: String? = null,
    val name: String? = null,
    val fclName: String? = null,
    val adminCodes1: ISOAdminCode,
    val countryName: String? = null,
    val fcodeName: String? = null,
    val adminName1: String? = null,
    val lat: String? = null,
    val fcode: String? = null
)

data class ISOAdminCode(
    val ISO3166_2: String? = null
)