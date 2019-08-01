package com.parisesoftware.excite.infrastructure.output

/**
 * Output Method
 * <p>
 * Common Excite Output Methods to Exemplify System Usage
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class OutputMethod {

    /**
     * Writes the Transformed Content back out as a File
     */
    static final Closure FILE = { File initialFile, String transformedContent ->
        initialFile.newWriter().withWriter { writer ->
            writer << transformedContent
        }
    }

    /**
     * Prints the Transformed Content out to the Console
     */
    static final Closure CONSOLE = { File initialFile, String transformedContent ->
        println transformedContent
    }

}
