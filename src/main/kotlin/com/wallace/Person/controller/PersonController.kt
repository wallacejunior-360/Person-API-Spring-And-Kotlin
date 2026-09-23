package com.wallace.Person.controller

import com.wallace.Person.model.Person
import com.wallace.Person.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @RequestMapping(method = [(RequestMethod.GET)],
                    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person> {
        return service.findAll()
    }

    @RequestMapping(value = ["/{id}"],
                    method = [(RequestMethod.GET)],
                    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long): Person {
        return service.findById(id)
    }

    @RequestMapping(method = [(RequestMethod.POST)],
                    produces = [MediaType.APPLICATION_JSON_VALUE],
                    consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return service.create(person)
    }

    @RequestMapping(method = [(RequestMethod.PUT)],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        return service.update(person)
    }

    @RequestMapping(value = ["/{id}"],
        method = [(RequestMethod.DELETE)],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long) {
        return service.delete(id)
    }
}