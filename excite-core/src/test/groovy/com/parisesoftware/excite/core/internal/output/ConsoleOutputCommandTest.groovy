package com.parisesoftware.excite.core.internal.output

import spock.lang.Specification

class ConsoleOutputCommandTest extends Specification {

    PrintStream originalOut
    ByteArrayOutputStream capturedOut

    def setup() {
        originalOut = System.out
        capturedOut = new ByteArrayOutputStream()
        System.setOut(new PrintStream(capturedOut))
    }

    def "execute prints transformed content to System.out"() {
        given:
        File someFile = new File('irrelevant.xml')

        when:
        new ConsoleOutputCommand().execute(someFile, 'content')

        then:
        capturedOut.toString().contains('content')
    }

    def cleanup() {
        System.setOut(originalOut)
    }

}
