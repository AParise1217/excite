package com.parisesoftware.excite.core.internal.transformer

import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class RenameChildNodeTransformationTest extends Specification {

    def "execute renames old node to new node and preserves value"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><old>value</old></root>')

        when:
        new RenameChildNodeTransformation('old', 'newname').execute(root)
        String result = XmlUtil.serialize(root)

        then:
        result.contains('newname')
        result.contains('value')
        !result.contains('<old>')
    }

}
