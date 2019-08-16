package com.parisesoftware.excite.core.internal.validation

import groovy.util.slurpersupport.GPathResult
import spock.lang.Specification

class AcceptAllValidationTest extends Specification {

    def "validation of a GPathResult"(GPathResult aNode, boolean isValid) {
        expect:
        new AcceptAllValidation().validate(aNode) == isValid

        where:
        aNode               || isValid
        null                || false
    }

}
