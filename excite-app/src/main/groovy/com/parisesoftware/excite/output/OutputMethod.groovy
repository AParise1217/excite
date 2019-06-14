package com.parisesoftware.excite.output

class OutputMethod {

    static final Closure FILE = { File initialFile, String transformedContent ->
        initialFile.newWriter().withWriter { writer ->
            writer << transformedContent
        }
    }

    static final Closure CONSOLE = { File initialFile, String transformedContent ->
        println transformedContent
    }

}
