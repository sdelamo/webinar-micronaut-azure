package com.example

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.validation.ConstraintViolationException

class NameTransformerSpec extends Specification {

    @AutoCleanup
    @Shared
    Function function = new Function()

    void "there is a bean of type NameTransformer"() {
        expect:
        function.applicationContext.containsBean(NameTransformer)

        when:
        NameTransformer nameTransformer = function.applicationContext.getBean(NameTransformer)
        nameTransformer.transform("")

        then:
        ConstraintViolationException e = thrown()
    }
}
