package com.adhish.catsapp.data.model

data class CatsResponse(
    val breeds: List<Breeds>? = null,
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val pending: Int,
    val approved: Int,
    val rejected: Int
)

data class Breeds(
    val id: Int,
    val name: String
)