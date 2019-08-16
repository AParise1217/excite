package com.parisesoftware.excite.core.internal

import com.parisesoftware.excite.core.api.IExciteFacade
import com.parisesoftware.excite.core.api.resolver.IFileParser
import com.parisesoftware.excite.core.api.resolver.IFileSystemService
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.internal.parser.FileParser
import com.parisesoftware.excite.core.internal.parser.FilePredicate
import com.parisesoftware.excite.core.internal.parser.FileSystemService
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import com.parisesoftware.excite.core.internal.transformer.MarkupTransformer
import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * {@inheritDoc}
 *
 * <p>
 * Default implementation of {@link IExciteFacade}
 *
 * @version 1.0.2
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
             final ITransformationAlgorithm aTransformationAlgorithm,
             final IValidationAlgorithm aValidationAlgorithm,
             final IOutputCommand anOutputCommand) {
        List<File> filesInDirectory = this.fileSystemService.getFilesInDirectory(aDirectory, GET_ONLY_XML_FILES)
        filesInDirectory.each { File curFile ->
            GPathResult fileContents = this.fileParser.parseFile(curFile)

            if (aValidationAlgorithm.validate(fileContents)) {
                String transformedContent = this.markupTransformer.transform(fileContents, aTransformationAlgorithm)
                anOutputCommand.execute(curFile, transformedContent)
            }
        }
    }
}
