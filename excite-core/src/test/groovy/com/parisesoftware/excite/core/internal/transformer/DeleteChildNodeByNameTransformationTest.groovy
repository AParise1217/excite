package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.MutableXmlNode
import spock.lang.Specification

class DeleteChildNodeByNameTransformationTest extends Specification {

    def "execute delegates deleteChildrenNamed to the node"() {
        given:
        MutableXmlNode node = Mock(MutableXmlNode)

        when:
        new DeleteChildNodeByNameTransformation('target').execute(node)

        then:
        1 * node.deleteChildrenNamed('target')
    }
}
