package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class MarkupTransformerTest extends Specification {

    def "transform with no-op algorithm returns serialized XML starting with XML declaration"() {
        given:
        GPathResult root = new XmlSlurper().parseText('<root><child>text</child></root>')
        ITransformationAlgorithm noOp = { GPathResult node -> } as ITransformationAlgorithm

        when:
        String result = new MarkupTransformer().transform(root, noOp)

        then:
        result.startsWith('<?xml')
    }

}
