package com.parisesoftware.excite.core.internal

import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class GPathResultXmlNodeTest extends Specification {

    def 'getName returns the element name'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        expect:
        new GPathResultXmlNode(xml).getName() == 'article'
    }

    def 'getText returns the text content'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article>hello</article>')

        expect:
        new GPathResultXmlNode(xml).getText() == 'hello'
    }

    def 'getChildText returns present Optional when child exists'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article><title>foo</title></article>')

        expect:
        new GPathResultXmlNode(xml).getChildText('title') == Optional.of('foo')
    }

    def 'getChildText returns empty Optional when child is absent'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        expect:
        new GPathResultXmlNode(xml).getChildText('missing') == Optional.empty()
    }

    def 'hasChild returns true when child exists'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article><title>foo</title></article>')

        expect:
        new GPathResultXmlNode(xml).hasChild('title')
    }

    def 'hasChild returns false when child is absent'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        expect:
        !new GPathResultXmlNode(xml).hasChild('missing')
    }

    def 'getAttribute returns present Optional when attribute exists'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article type="news"/>')

        expect:
        new GPathResultXmlNode(xml).getAttribute('type') == Optional.of('news')
    }

    def 'getAttribute returns empty Optional when attribute is absent'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        expect:
        new GPathResultXmlNode(xml).getAttribute('missing') == Optional.empty()
    }

    def 'renameChildrenNamed renames all matching children'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article><desc>x</desc><desc>y</desc></article>')
        GPathResultXmlNode node = new GPathResultXmlNode(xml)

        when:
        node.renameChildrenNamed('desc', 'description')
        String result = XmlUtil.serialize(xml)

        then:
        result.contains('<description>')
        !result.contains('<desc>')
    }

    def 'deleteChildrenNamed removes all matching children'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article><draft/><keep/></article>')
        GPathResultXmlNode node = new GPathResultXmlNode(xml)

        when:
        node.deleteChildrenNamed('draft')

        then:
        !node.hasChild('draft')
        node.hasChild('keep')
    }

    def 'addChild throws UnsupportedOperationException'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        when:
        new GPathResultXmlNode(xml).addChild('x', 'y')

        then:
        thrown(UnsupportedOperationException)
    }

    def 'setValue throws UnsupportedOperationException'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        when:
        new GPathResultXmlNode(xml).setValue('x')

        then:
        thrown(UnsupportedOperationException)
    }

    def 'setAttribute throws UnsupportedOperationException'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        when:
        new GPathResultXmlNode(xml).setAttribute('k', 'v')

        then:
        thrown(UnsupportedOperationException)
    }

    def 'renameAttribute throws UnsupportedOperationException'() {
        given:
        GPathResult xml = new XmlSlurper().parseText('<article/>')

        when:
        new GPathResultXmlNode(xml).renameAttribute('a', 'b')

        then:
        thrown(UnsupportedOperationException)
    }
}
