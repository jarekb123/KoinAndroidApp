package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.PostData
import com.butajlo.koinandroidapp.domain.entity.PostEntity

fun PostData.toEntity() = PostEntity(userId, id, title, body)