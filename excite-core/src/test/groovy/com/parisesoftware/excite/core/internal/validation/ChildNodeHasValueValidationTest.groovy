package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.XmlNode
import spock.lang.Specification

class ChildNodeHasValueValidationTest extends Specification {

    def "validate returns false for null node"() {
        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(null) == false
    }

    def "validate returns false when child is absent"() {
        given:
        XmlNode node = Mock(XmlNode)
        node.getChildText('type') >> Optional.empty()

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == false
    }

    def "validate returns false when child has wrong value"() {
        given:
        XmlNode node = Mock(XmlNode)
        node.getChildText('type') >> Optional.of('wrong')

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == false
    }

    def "validate returns true when child has correct value"() {
        given:
        XmlNode node = Mock(XmlNode)
        node.getChildText('type') >> Optional.of('match')

        expect:
        new ChildNodeHasValueValidation('type', 'match').validate(node) == true
    }
}
