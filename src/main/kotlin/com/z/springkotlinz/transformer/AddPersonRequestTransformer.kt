package com.z.springkotlinz.transformer

import com.z.springkotlinz.domain.Person
import com.z.springkotlinz.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
                name = source.name,
                lastName = source.lastName
        )
    }
}