package com.z.springkotlinz.transformer

import com.z.springkotlinz.domain.Person
import com.z.springkotlinz.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
    )
}