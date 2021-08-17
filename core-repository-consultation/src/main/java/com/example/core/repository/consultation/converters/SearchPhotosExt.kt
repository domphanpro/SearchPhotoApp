package com.example.core.repository.consultation.converters

import com.example.core.model.consultation.Result
import com.example.core.model.consultation.SearchPhotos
import com.example.core.model.consultation.UrlsPhoto
import com.example.core.repository.consultation.model.ResultResponse
import com.example.core.repository.consultation.model.SearchPhotosResponse
import com.example.core.repository.consultation.model.UrlsPhotoResponse

internal fun SearchPhotosResponse.toModel() = SearchPhotos(
    total = total,
    total_pages = total_pages,
    results = results.map { it.toModel() }
)

internal fun ResultResponse.toModel() = Result(
    alt_description = alt_description,
    description = description,
    created_at = created_at,
    id = id,
    urls = urls.toModel()
)

internal fun UrlsPhotoResponse.toModel() = UrlsPhoto(
    full = full,
    raw = raw,
    regular = regular,
    small = small,
    thumb = thumb
)