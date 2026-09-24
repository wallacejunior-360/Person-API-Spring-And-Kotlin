package com.wallace.Person.controller

import com.wallace.Person.data.vo.v1.PersonVO
import com.wallace.Person.model.Person
import com.wallace.Person.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person/v1")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"],
                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long): PersonVO {
        return service.findById(id)
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
                 consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
                consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: PersonVO): PersonVO {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
                    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}