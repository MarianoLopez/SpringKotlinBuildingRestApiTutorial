package com.z.springkotlinz.service

import com.z.springkotlinz.dao.PersonDao
import com.z.springkotlinz.domain.Person
import com.z.springkotlinz.dto.AddPersonRequest
import com.z.springkotlinz.dto.PersonResponse
import com.z.springkotlinz.dto.UpdatePersonRequest
import com.z.springkotlinz.transformer.AddPersonRequestTransformer
import com.z.springkotlinz.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao,
                                  private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(): List<PersonResponse> = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
                addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}