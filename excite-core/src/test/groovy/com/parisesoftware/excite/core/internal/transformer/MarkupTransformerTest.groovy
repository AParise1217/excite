package com.parisesoftware.excite.core.internal.transformer

import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class MarkupTransformerTest extends Specification {

    def "serialize returns XML string starting with XML declaration"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><child>text</child></root>')

        when:
        String result = new MarkupTransformer().serialize(root)

        then:
        result.startsWith('<?xml')
    }
}
