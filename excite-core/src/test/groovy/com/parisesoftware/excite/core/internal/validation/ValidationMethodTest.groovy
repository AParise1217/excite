package com.parisesoftware.excite.core.internal.validation

import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class ValidationMethodTest extends Specification {

    def "ACCEPT_ALL predicate returns false for null"() {
        expect:
        ValidationMethod.ACCEPT_ALL.test(null) == false
    }

    def "ACCEPT_ALL predicate returns true for a valid GPathResult"() {
        given:
        GPathResult node = new XmlSlurper().parseText('<root/>')

        expect:
        ValidationMethod.ACCEPT_ALL.test(node) == true
    }

}
