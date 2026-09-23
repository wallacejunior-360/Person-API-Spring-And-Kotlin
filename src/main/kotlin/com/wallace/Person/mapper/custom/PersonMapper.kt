package com.wallace.Person.mapper.custom

import com.wallace.Person.data.vo.v2.PersonVO
import com.wallace.Person.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.address = person.address
        vo.birthDate = Date()
        vo.gender = person.gender

        return vo;
    }

    fun mapVoToENtity(vo: PersonVO): Person {
        val person = Person()
        person.id = vo.id
        person.firstName = vo.firstName
        person.lastName = vo.lastName
        person.address = vo.address
        person.gender = vo.gender

        return person;
    }
}