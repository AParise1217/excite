package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.MutableXmlNode
import spock.lang.Specification

class RenameChildNodeTransformationTest extends Specification {

    def "execute delegates renameChildrenNamed to the node"() {
        given:
        MutableXmlNode node = Mock(MutableXmlNode)

        when:
        new RenameChildNodeTransformation('old', 'newname').execute(node)

        then:
        1 * node.renameChildrenNamed('old', 'newname')
    }
}
