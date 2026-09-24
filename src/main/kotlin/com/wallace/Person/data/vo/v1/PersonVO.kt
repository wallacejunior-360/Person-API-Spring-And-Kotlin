package com.wallace.Person.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonPropertyOrder("id", "address", "firstName", "lastName", "gender")
data class PersonVO (
    var id: Long = 0,
    @JsonProperty("first_name")
    var firstName: String = "",
    @JsonProperty("last_name")
    var lastName: String = "",
    var address: String = "",
    @JsonIgnore
    var gender: String = ""
)