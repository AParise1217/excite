package com.parisesoftware.excite.internal

import com.parisesoftware.excite.IExciteFacade
import com.parisesoftware.excite.filesystem.internal.FileParser
import com.parisesoftware.excite.filesystem.IFileParser
import com.parisesoftware.excite.filesystem.internal.FileSystemService
import com.parisesoftware.excite.filesystem.IFileSystemService
import com.parisesoftware.excite.transformer.IMarkupTransformer
import com.parisesoftware.excite.transformer.internal.MarkupTransformer
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IExciteFacade}
 */
class ExciteFacade implements IExciteFacade {

    /**
     * {@inheritDoc}
     */
    void run(String aDirectory, Closure aTransformationAlgorithm, Closure anOutputAlgorithm) {
        // Dependent Excite Delegations
        IMarkupTransformer markupTransformer = new MarkupTransformer()
        IFileSystemService fileSystemService = new FileSystemService()
        IFileParser fileParser = new FileParser()

        // Excite Runner Logic
        List<File> filesInDirectory = fileSystemService.getFilesInDirectory(aDirectory)
        filesInDirectory.each { File curFile ->
            GPathResult fileContents = fileParser.parseFile(curFile)
            String transformedContent = markupTransformer.transform(fileContents, aTransformationAlgorithm)
            anOutputAlgorithm.call(curFile, transformedContent)
        }

    }

}
