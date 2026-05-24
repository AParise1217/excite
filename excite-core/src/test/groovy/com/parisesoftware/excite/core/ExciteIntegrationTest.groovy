package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.internal.output.ConsoleOutputCommand
import com.parisesoftware.excite.core.internal.transformer.DeleteChildNodeByNameTransformation
import com.parisesoftware.excite.core.internal.validation.ChildNodeHasValueValidation
import spock.lang.Specification

class ExciteIntegrationTest extends Specification {

    File tempDir
    PrintStream originalOut
    ByteArrayOutputStream capturedOut

    def "run processes matching XML file and deletes type node, skipping non-matching file"() {
        given:
        tempDir = File.createTempDir()
        new File(tempDir, 'match.xml').setText('<root><type>target</type></root>', 'UTF-8')
        new File(tempDir, 'nomatch.xml').setText('<root><type>other</type></root>', 'UTF-8')

        originalOut = System.out
        capturedOut = new ByteArrayOutputStream()
        System.setOut(new PrintStream(capturedOut))

        when:
        Excite.run(
            tempDir.absolutePath,
            new DeleteChildNodeByNameTransformation('type'),
            new ChildNodeHasValueValidation('type', 'target'),
            new ConsoleOutputCommand()
        )

        then:
        String output = capturedOut.toString()
        output.contains('<?xml')
        !output.contains('<type>')
        !output.contains('target')
        noExceptionThrown()

        cleanup:
        System.setOut(originalOut)
        tempDir?.deleteDir()
    }

}
