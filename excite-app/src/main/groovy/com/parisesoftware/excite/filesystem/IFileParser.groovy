package com.parisesoftware.excite

import groovy.util.slurpersupport.GPathResult

/**
 * Utility for Parsing out File Content
 */
interface IFileParser {

    /**
     * Parses a {@link File} as a {@link GPathResult}
     * @param aFile to be parsed
     * @return {@code GPathResult} a GPath Style Parsed File
     */
    GPathResult parseFile(File aFile)

}
