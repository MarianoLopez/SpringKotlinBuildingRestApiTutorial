package com.z.springkotlinz.resource

import com.z.springkotlinz.dto.AddPersonRequest
import com.z.springkotlinz.dto.PersonResponse
import com.z.springkotlinz.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findById(id:Long): ResponseEntity<PersonResponse?>
    fun findAll(): ResponseEntity<List<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id:Long): ResponseEntity<Unit>
}