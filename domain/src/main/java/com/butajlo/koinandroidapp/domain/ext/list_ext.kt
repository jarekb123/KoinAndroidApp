package com.butajlo.koinandroidapp.domain.ext

import java.util.*

/**
 * Returns Random element from [List]
 */
fun <T> List<T>.random(): T {
    return get(random(0..size))
}

/**
 * Returns random Int number from specified [range]
 */
private fun random(range: IntRange): Int {
    return Random().nextInt(range.last - range.start) + range.start
}