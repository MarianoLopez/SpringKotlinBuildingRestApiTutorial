package com.z.springkotlinz.resource

import com.z.springkotlinz.dto.AddPersonRequest
import com.z.springkotlinz.dto.PersonResponse
import com.z.springkotlinz.dto.UpdatePersonRequest
import com.z.springkotlinz.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.z.springkotlinz.service.PersonManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonResourceImpl(private val personManagementService: PersonManagementService) : PersonResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        val personResponse: PersonResponse? = this.personManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> = ResponseEntity.ok(this.personManagementService.findAll())

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManagementService.save(addPersonRequest)
        return ResponseEntity
                .created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}")))
                .body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok(this.personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personManagementService.deleteById(id)
        return ResponseEntity.noContent().build();
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}