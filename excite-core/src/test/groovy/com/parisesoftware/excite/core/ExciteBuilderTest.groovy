package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.api.ExciteResult
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.api.XmlNode
import spock.lang.Specification

class ExciteBuilderTest extends Specification {

    def 'run returns ExciteResult with correct filesProcessed count'() {
        given:
        File tempDir = File.createTempDir()
        new File(tempDir, 'a.xml').setText('<root/>', 'UTF-8')
        new File(tempDir, 'b.xml').setText('<root/>', 'UTF-8')

        when:
        ExciteResult result = Excite.builder(
            tempDir.absolutePath,
            Mock(ITransformationAlgorithm),
            { XmlNode node -> true } as IValidationAlgorithm,
            Mock(IOutputCommand)
        ).run()

        then:
        result.filesProcessed == 2

        cleanup:
        tempDir?.deleteDir()
    }

    def 'builder throws IllegalArgumentException when directory is null'() {
        when:
        Excite.builder(null, Mock(ITransformationAlgorithm), Mock(IValidationAlgorithm), Mock(IOutputCommand))

        then:
        thrown(IllegalArgumentException)
    }

    def 'builder throws IllegalArgumentException when transformation is null'() {
        when:
        Excite.builder('/some/dir', null, Mock(IValidationAlgorithm), Mock(IOutputCommand))

        then:
        thrown(IllegalArgumentException)
    }

    def 'builder throws IllegalArgumentException when validation is null'() {
        when:
        Excite.builder('/some/dir', Mock(ITransformationAlgorithm), null, Mock(IOutputCommand))

        then:
        thrown(IllegalArgumentException)
    }

    def 'builder throws IllegalArgumentException when output is null'() {
        when:
        Excite.builder('/some/dir', Mock(ITransformationAlgorithm), Mock(IValidationAlgorithm), null)

        then:
        thrown(IllegalArgumentException)
    }
}
