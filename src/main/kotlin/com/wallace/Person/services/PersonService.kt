package com.wallace.Person.services

import com.wallace.Person.data.vo.v1.PersonVO
import com.wallace.Person.exceptions.ResourceNotFoundException
import com.wallace.Person.mapper.DozerMapper
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

    fun findAll(): List<PersonVO> {
        logger.info("Trying to find all Persons")

        val people =  personRepository.findAll()

        return DozerMapper.parseListObjects(people, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Trying to find Person with id: $id")

        var person = personRepository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("Person with id: $id not found") }

        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Trying to create Person with name: ${person.firstName}")

        var entity: Person = DozerMapper.parseObject(person, Person::class.java)

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Trying to update Person with id: ${person.id}")

        val entity = personRepository
            .findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person with id: ${person.id} not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Trying to delete Person with id: $id")

        val person = personRepository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("Person with id: $id not found") }

        personRepository.delete(person)
    }

}

