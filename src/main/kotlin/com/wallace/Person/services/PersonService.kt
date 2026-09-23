package com.wallace.Person.services

import com.wallace.Person.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Trying to find all Persons")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = MockPerson(i)
            persons.add(person)
        }

        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Trying to find Person with id: $id")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firtName = "Wallace"
        person.lastName = "Junior"
        person.address = "Salgueiro, 119"
        person.gender = "Male"

        return person
    }

    fun create(person: Person): Person {
        logger.info("Trying to create Person with id: ${person.id}")

        return person
    }

    fun update(person: Person): Person {
        logger.info("Trying to update Person with id: ${person.id}")
        return person
    }

    fun delete(id: Long) {
        logger.info("Trying to delete Person with id: $id")
    }

    private fun MockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firtName = "Wallace${i}"
        person.lastName = "Junior${i}"
        person.address = "Address, ${i}"
        person.gender = "Male"
        return person
    }
}

