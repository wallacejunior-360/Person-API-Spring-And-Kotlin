package com.wallace.Person.services

import com.wallace.Person.exceptions.ResourceNotFoundException
import com.wallace.Person.model.Person
import com.wallace.Person.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Trying to find all Persons")

        return personRepository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Trying to find Person with id: $id")

        return personRepository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("Person with id: $id not found") }
    }

    fun create(person: Person): Person {
        logger.info("Trying to create Person with name: ${person.firtName}")

        return personRepository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Trying to update Person with id: ${person.id}")

        val entity = personRepository
            .findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person with id: ${person.id} not found") }

        entity.firtName = person.firtName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return personRepository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Trying to delete Person with id: $id")

        val person = personRepository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("Person with id: $id not found") }

        personRepository.delete(person)
    }

}

