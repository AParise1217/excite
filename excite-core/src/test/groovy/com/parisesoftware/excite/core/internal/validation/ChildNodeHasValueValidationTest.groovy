package com.parisesoftware.excite.core.internal.validation

import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class ChildNodeHasValueValidationTest extends Specification {

    def "validate returns false for null node"() {
        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(null) == false
    }

    def "validate returns false when target child node is absent"() {
        given:
        GPathResult node = new XmlSlurper().parseText('<root/>')

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == false
    }

    def "validate returns false when child node has wrong value"() {
        given:
        GPathResult node = new XmlSlurper().parseText('<root><type>wrong</type></root>')

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == false
    }

    def "validate returns true when child node has correct value"() {
        given:
        GPathResult node = new XmlSlurper().parseText('<root><type>match</type></root>')

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == true
    }

}
