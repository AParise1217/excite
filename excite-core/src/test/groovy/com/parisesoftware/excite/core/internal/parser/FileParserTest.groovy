package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.ExciteException
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

class FileParserTest extends Specification {

    File validTempFile
    File invalidTempFile

    def "parseFile returns correct GPathResult for valid XML"() {
        given:
        validTempFile = File.createTempFile('excite-test-', '.xml')
        validTempFile.setText('<myroot><child>hello</child></myroot>', 'UTF-8')

        when:
        GPathResult result = new FileParser().parseFile(validTempFile)

        then:
        result.name() == 'myroot'
    }

    def "parseFile throws ExciteException for invalid XML content"() {
        given:
        invalidTempFile = File.createTempFile('excite-test-bad-', '.xml')
        invalidTempFile.setText('not xml content', 'UTF-8')

        when:
        new FileParser().parseFile(invalidTempFile)

        then:
        thrown(ExciteException)
    }

    def cleanup() {
        validTempFile?.delete()
        invalidTempFile?.delete()
    }

}
