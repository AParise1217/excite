package com.parisesoftware.excite.core.internal.impl

import com.parisesoftware.excite.core.internal.IExciteFacade
import com.parisesoftware.excite.core.transformer.IMarkupTransformer
import com.parisesoftware.excite.core.transformer.internal.MarkupTransformer
import com.parisesoftware.excite.core.validation.ValidationMethod
import com.parisesoftware.excite.infrastructure.filesystem.IFileParser
import com.parisesoftware.excite.infrastructure.filesystem.IFileSystemService
import com.parisesoftware.excite.infrastructure.filesystem.internal.FileParser
import com.parisesoftware.excite.infrastructure.filesystem.internal.FilePredicate
import com.parisesoftware.excite.infrastructure.filesystem.internal.FileSystemService
import com.parisesoftware.excite.infrastructure.output.OutputMethod
import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * {@inheritDoc}
 *
 * <p>
 * Default implementation of {@link IExciteFacade}
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class ExciteFacadeImpl implements IExciteFacade {

    private static final Predicate<File> GET_ONLY_XML_FILES = FilePredicate.isXmlFile

    IMarkupTransformer markupTransformer

    IFileSystemService fileSystemService

    IFileParser fileParser

    ExciteFacadeImpl() {
        this.markupTransformer = new MarkupTransformer()
        this.fileSystemService = new FileSystemService()
        this.fileParser = new FileParser()
    }

    /**
     * {@inheritDoc}
     */
    void run(final String aDirectory,
             final Closure aTransformationAlgorithm,
             final Predicate<GPathResult> aValidationAlgorithm = ValidationMethod.ACCEPT_ALL,
             final Closure anOutputAlgorithm = OutputMethod.CONSOLE) {

        // Excite Runner Logic
        List<File> filesInDirectory = this.fileSystemService.getFilesInDirectory(aDirectory, GET_ONLY_XML_FILES)
        filesInDirectory.each { File curFile ->
            GPathResult fileContents = this.fileParser.parseFile(curFile)

            if (aValidationAlgorithm.test(fileContents)) {
                String transformedContent = this.markupTransformer.transform(fileContents, aTransformationAlgorithm)
                anOutputAlgorithm.call(curFile, transformedContent)
            }
        }

    }

}
