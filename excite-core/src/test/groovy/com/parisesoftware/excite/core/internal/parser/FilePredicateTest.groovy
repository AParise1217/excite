package com.parisesoftware.excite.core.internal.parser

import spock.lang.Specification

class FilePredicateTest extends Specification {

    def "isXmlFile returns expected result for various file names"(File file, boolean expected) {
        expect:
        FilePredicate.isXmlFile.test(file) == expected

        where:
        file                    || expected
        new File('test.xml')    || true
        new File('TEST.XML')    || true
        new File('test.txt')    || false
        new File('noext')       || false
    }

}
