package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.ExciteException
import spock.lang.Specification

class FileSystemServiceTest extends Specification {

    File tempDir

    def "getFilesInDirectory returns only XML files from a directory"() {
        given:
        tempDir = File.createTempDir()
        new File(tempDir, 'file1.xml').setText('<root/>', 'UTF-8')
        new File(tempDir, 'file2.xml').setText('<root/>', 'UTF-8')
        new File(tempDir, 'file3.txt').setText('plain text', 'UTF-8')

        when:
        List<File> result = new FileSystemService().getFilesInDirectory(tempDir.absolutePath)

        then:
        result.size() == 2
        result.every { it.name.endsWith('.xml') }
    }

    def "getFilesInDirectory throws ExciteException for non-existent path"() {
        when:
        new FileSystemService().getFilesInDirectory('/this/path/does/not/exist/at/all')

        then:
        thrown(ExciteException)
    }

    def cleanup() {
        tempDir?.deleteDir()
    }

}
