package com.z.springkotlinz.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}