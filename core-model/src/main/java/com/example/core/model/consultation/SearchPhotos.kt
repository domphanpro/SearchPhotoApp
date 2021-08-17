package com.example.core.model.consultation

data class SearchPhotos(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)