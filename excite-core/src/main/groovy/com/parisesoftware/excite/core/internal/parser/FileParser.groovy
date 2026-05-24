package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.ExciteException
import com.parisesoftware.excite.core.api.resolver.IFileParser
import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult

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
        try {
            final String fileText = aFile.getText('UTF-8')
            return new XmlSlurper().parseText(fileText)
        } catch (Exception e) {
            throw new ExciteException("Failed to parse XML file: ${aFile.absolutePath}", e)
        }
    }

}
