package com.parisesoftware.excite.infrastructure.filesystem.internal

import java.util.function.Predicate

/**
 * File Predicate
 * <p>
 * Collection of Useful Java 8 Predicates for {@link File}s
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class FilePredicate {

    private static final String XML_FILE_EXTENSION = '.xml'

    static final Predicate<File> isXmlFile = { File aFile ->
        aFile.name.endsWith(XML_FILE_EXTENSION)
    }

}
