package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.XmlNode
import spock.lang.Specification

class AcceptAllValidationTest extends Specification {

    def "validate returns false for null node"() {
        expect:
        new AcceptAllValidation().validate(null) == false
    }

    def "validate returns true for a non-null XmlNode"() {
        given:
        XmlNode node = Mock(XmlNode)

        expect:
        new AcceptAllValidation().validate(node) == true
    }
}
