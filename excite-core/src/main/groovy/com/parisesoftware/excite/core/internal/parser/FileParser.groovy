package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.resolver.IFileParser
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 *
 * <p>
 * Default implementation of {@link IFileParser}
 *
 * @version 1.0.0
 * @since 1.0.0
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
