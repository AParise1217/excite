package com.parisesoftware.excite

import java.util.function.Predicate

/**
 * Collection of Useful Java 8 Predicates for {@link File}s
 */
class FilePredicate {

    private static final String XML_FILE_EXTENSION = '.xml'

    static final Predicate<File> isXmlFile = { File aFile ->
        aFile.name.endsWith(XML_FILE_EXTENSION)
    }

}
