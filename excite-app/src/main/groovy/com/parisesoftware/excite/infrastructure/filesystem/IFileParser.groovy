package com.parisesoftware.excite.infrastructure.filesystem

import groovy.util.slurpersupport.GPathResult

/**
 * File Parser
 * <p>
 * Utility for Parsing out File Content
 *
 * @version 1.0.0
 * @since 1.0.0
 */
interface IFileParser {

    /**
     * Parses a {@link File} as a {@link GPathResult}
     * @version 1.0.0
     * @param aFile to be parsed
     * @return {@code GPathResult} a GPath Style Parsed File
     * @since 1.0.0
     */
    GPathResult parseFile(File aFile)

}
