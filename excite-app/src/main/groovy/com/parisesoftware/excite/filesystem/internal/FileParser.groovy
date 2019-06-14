package com.parisesoftware.excite.filesystem.internal

import com.parisesoftware.excite.filesystem.IFileParser
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IFileParser}
 */
class FileParser implements IFileParser {

    /**
     * {@inheritDoc}
     */
    @Override
    GPathResult parseFile(File aFile) {
        final String fileText = aFile.text
        return new XmlSlurper().parseText(fileText)
    }

}
