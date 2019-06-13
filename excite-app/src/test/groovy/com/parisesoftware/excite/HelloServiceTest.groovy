package com.parisesoftware.excite

import spock.lang.Specification

class HelloServiceTest extends Specification {

    def "GetMessage Should Return 'Hello World!'"() {
        when: 'the HelloService is queried for a message'
        String resultant = HelloService.getMessage()

        then: 'the resultant String is equal to \'Hello World\''
        resultant == 'Hello World!'
    }

}
