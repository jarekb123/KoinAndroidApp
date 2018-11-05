package com.butajlo.koinandroidapp.sharedbindings

import com.butajlo.koinandroidapp.domain.entity.PostEntity

fun PostEntity.toBindingModel(isFavorite: Boolean, info: String = "") =
        CardPostBindingModel(
            id = id,
            title = title,
            content = body,
            imageUrl = "https://picsum.photos/160/160/?random=$id", // random 160x160 photo
            isFavorite = isFavorite,
            info = info
        )