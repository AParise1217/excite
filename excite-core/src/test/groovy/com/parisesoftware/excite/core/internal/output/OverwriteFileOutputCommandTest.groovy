package com.parisesoftware.excite.core.internal.output

import com.parisesoftware.excite.core.api.ExciteException
import spock.lang.Specification

class OverwriteFileOutputCommandTest extends Specification {

    File tempFile

    def "execute overwrites temp file with provided content"() {
        given:
        tempFile = File.createTempFile('excite-output-', '.xml')

        when:
        new OverwriteFileOutputCommand().execute(tempFile, '<root/>')

        then:
        tempFile.getText('UTF-8') == '<root/>'
    }

    def "execute throws an exception when writing to file in non-existent directory"() {
        given:
        File badFile = new File('/this/path/does/not/exist/output.xml')

        when:
        new OverwriteFileOutputCommand().execute(badFile, '<root/>')

        then:
        thrown(Exception)
    }

    def cleanup() {
        tempFile?.delete()
    }

}
