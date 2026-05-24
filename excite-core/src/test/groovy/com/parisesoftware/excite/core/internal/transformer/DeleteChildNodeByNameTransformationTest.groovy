package com.parisesoftware.excite.core.internal.transformer

import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class DeleteChildNodeByNameTransformationTest extends Specification {

    def "execute removes the target child node"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><target>value</target><other>keep</other></root>')

        when:
        new DeleteChildNodeByNameTransformation('target').execute(root)
        String result = XmlUtil.serialize(root)

        then:
        !result.contains('<target>')
        result.contains('keep')
    }

}
