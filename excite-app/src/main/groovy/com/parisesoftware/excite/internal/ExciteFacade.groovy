package com.parisesoftware.excite.internal

import com.parisesoftware.excite.IExciteFacade
import com.parisesoftware.excite.filesystem.IFileParser
import com.parisesoftware.excite.filesystem.IFileSystemService
import com.parisesoftware.excite.filesystem.internal.FileParser
import com.parisesoftware.excite.filesystem.internal.FileSystemService
import com.parisesoftware.excite.output.OutputMethod
import com.parisesoftware.excite.transformer.IMarkupTransformer
import com.parisesoftware.excite.transformer.internal.MarkupTransformer
import com.parisesoftware.excite.validation.ValidationMethod
import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IExciteFacade}
 */
class ExciteFacade implements IExciteFacade {

    /**
     * {@inheritDoc}
     */
    void run(final String aDirectory,
             final Closure aTransformationAlgorithm,
             final Predicate<GPathResult> aValidationAlgorithm = ValidationMethod.ACCEPT_ALL,
             final Closure anOutputAlgorithm = OutputMethod.CONSOLE) {

        // Dependent Excite Delegations
        IMarkupTransformer markupTransformer = new MarkupTransformer()
        IFileSystemService fileSystemService = new FileSystemService()
        IFileParser fileParser = new FileParser()

        // Excite Runner Logic
        List<File> filesInDirectory = fileSystemService.getFilesInDirectory(aDirectory)
        filesInDirectory.each { File curFile ->
            GPathResult fileContents = fileParser.parseFile(curFile)

            if (aValidationAlgorithm.test(fileContents)) {
                String transformedContent = markupTransformer.transform(fileContents, aTransformationAlgorithm)
                anOutputAlgorithm.call(curFile, transformedContent)
            }
        }

    }

}
