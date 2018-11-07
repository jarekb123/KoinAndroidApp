package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.PostData
import com.butajlo.koinandroidapp.domain.entity.PostEntity

fun PostData.toEntity() = PostEntity(
    userId = userId,
    id = id,
    title = title,
    body = body,
    imageUrl = "https://picsum.photos/300/160/?random=$id",
    thumbnailUrl = "https://picsum.photos/160/160/?random=$id"
)