package com.example.core.repository.consultation.converters

import com.example.core.model.consultation.Result
import com.example.core.model.consultation.SearchPhotos
import com.example.core.model.consultation.UrlsPhoto
import com.example.core.repository.consultation.model.ResultResponse
import com.example.core.repository.consultation.model.SearchPhotosResponse
import com.example.core.repository.consultation.model.UrlsPhotoResponse
import com.example.core.repository.consultation.room.Result as ModelDBPhotoSP

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
    urlThumb = urls.thumb
)

internal fun UrlsPhotoResponse.toModel() = UrlsPhoto(
    full = full,
    raw = raw,
    regular = regular,
    small = small,
    thumb = thumb
)

internal fun ModelDBPhotoSP.toModel() = Result(
    alt_description = alt_description,
    description = description,
    created_at = created_at,
    id = id,
    urlThumb = urls
)

internal fun Result.toModel() = ModelDBPhotoSP(
    alt_description = alt_description,
    description = description,
    created_at = created_at,
    id = id,
    urls = urlThumb
)