package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.microsoft.azure.functions.HttpStatus
import io.micronaut.azure.function.http.HttpRequestMessageBuilder
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpMethod
import io.micronaut.http.MediaType
import spock.lang.AutoCleanup
import spock.lang.Specification

class PersonControllerSpec extends Specification {

    @AutoCleanup
    Function function = new Function()

    void "/person uses name transformer"() {
        given:
        ObjectMapper objectMapper = function.applicationContext.getBean(ObjectMapper)

        when:
        Person person = new Person("sergio")
        HttpRequestMessageBuilder.AzureHttpResponseMessage response = postPerson(person)

        then: "The response is correct"
        response.status == HttpStatus.OK
        response.bodyAsString ==
                objectMapper.writeValueAsString(new Person("SERGIO"))
    }

    void "invalid person triggers bad request"() {
        when:
        HttpRequestMessageBuilder.AzureHttpResponseMessage response = postPerson(new Person())

        then:
        response.status == HttpStatus.BAD_REQUEST
    }

    HttpRequestMessageBuilder.AzureHttpResponseMessage postPerson(Person person) {
        function.request(HttpMethod.POST, "/person")
                .body(person)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .invoke()
    }
}
