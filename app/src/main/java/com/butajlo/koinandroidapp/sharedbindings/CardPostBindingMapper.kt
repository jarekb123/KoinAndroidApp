package com.butajlo.koinandroidapp.sharedbindings

import com.butajlo.koinandroidapp.domain.entity.PostEntity

fun PostEntity.toBindingModel(isFavorite: Boolean, info: String = "") =
        CardPostBindingModel(
            id = id,
            title = title,
            content = body,
            imageUrl = thumbnailUrl,
            isFavorite = isFavorite,
            info = info
        )