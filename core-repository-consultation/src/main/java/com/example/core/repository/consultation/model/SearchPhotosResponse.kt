package com.example.core.repository.consultation.model

data class SearchPhotosResponse(
    val results: List<ResultResponse>,
    val total: Int,
    val total_pages: Int
)

data class ResultResponse(
    val alt_description: String?,
    val description: String?,
    val created_at: String,
    val id: String,
    val urls: UrlsPhotoResponse,
)

data class UrlsPhotoResponse(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)