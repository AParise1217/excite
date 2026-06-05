package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.XmlNode
import spock.lang.Specification

class ValidationMethodTest extends Specification {

    def "ACCEPT_ALL predicate returns false for null"() {
        expect:
        ValidationMethod.ACCEPT_ALL.test(null) == false
    }

    def "ACCEPT_ALL predicate returns true for a valid XmlNode"() {
        given:
        XmlNode node = Mock(XmlNode)

        expect:
        ValidationMethod.ACCEPT_ALL.test(node) == true
    }
}
