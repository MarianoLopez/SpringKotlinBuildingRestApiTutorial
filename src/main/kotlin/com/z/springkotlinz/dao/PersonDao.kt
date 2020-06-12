package com.z.springkotlinz.dao

import com.z.springkotlinz.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long>