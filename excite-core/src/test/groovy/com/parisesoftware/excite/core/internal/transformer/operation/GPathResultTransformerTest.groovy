package com.parisesoftware.excite.core.internal.transformer.operation

import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class GPathResultTransformerTest extends Specification {

    def "deleteChildNodesWithName removes the specified child node"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><child>val</child></root>')

        when:
        GPathResultTransformer.deleteChildNodesWithName(root, 'child')
        String result = XmlUtil.serialize(root)

        then:
        !result.contains('<child>')
    }

    def "renameChildNodesWithName renames the specified child node and preserves its value"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><child>val</child></root>')

        when:
        GPathResultTransformer.renameChildNodesWithName(root, 'child', 'renamed')
        String result = XmlUtil.serialize(root)

        then:
        result.contains('renamed')
        result.contains('val')
    }

    def "deleteChildNodesWithName does not throw when name does not exist"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><child>val</child></root>')

        when:
        GPathResultTransformer.deleteChildNodesWithName(root, 'nonexistent')

        then:
        noExceptionThrown()
    }

}
