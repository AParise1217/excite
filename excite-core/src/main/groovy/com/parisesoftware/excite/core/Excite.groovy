package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.api.IExciteFacade
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import com.parisesoftware.excite.core.api.resolver.IFileParser
import com.parisesoftware.excite.core.api.resolver.IFileSystemService
import com.parisesoftware.excite.core.internal.ExciteFacadeImpl

/**
 * Excite Facade
 *
 * <p>
 * Static Entry-point to the Excite Domain
 *
 * @version 1.0.2
 * @since 1.0.0
 */
class Excite {

    /**
     * Runs the Excite Application Against the given parameters
     * @param aDirectory to scan for potential files
     * @param aTransformationAlgorithm to perform on the files that pass the validation
     * @param aValidationAlgorithm to filter the discovered files in the given directory
     * @param anOutputCommand to handle exporting the resultant transformed content
     */
    static void run(final String aDirectory, final ITransformationAlgorithm aTransformationAlgorithm,
                    final IValidationAlgorithm aValidationAlgorithm, final IOutputCommand anOutputCommand) {
        if (aDirectory == null) throw new IllegalArgumentException('aDirectory must not be null')
        if (aTransformationAlgorithm == null) throw new IllegalArgumentException('aTransformationAlgorithm must not be null')
        if (aValidationAlgorithm == null) throw new IllegalArgumentException('aValidationAlgorithm must not be null')
        if (anOutputCommand == null) throw new IllegalArgumentException('anOutputCommand must not be null')
        facade().run(aDirectory, aTransformationAlgorithm, aValidationAlgorithm, anOutputCommand)
    }

    /**
     * Creates an ExciteBuilder with the given parameters
     * @param directory to scan for potential files
     * @param transformation to perform on the files that pass the validation
     * @param validation to filter the discovered files in the given directory
     * @param output to handle exporting the resultant transformed content
     * @return {@code ExciteBuilder} configured with the provided parameters
     */
    static ExciteBuilder builder(String directory,
                                  ITransformationAlgorithm transformation,
                                  IValidationAlgorithm validation,
                                  IOutputCommand output) {
        if (directory == null) throw new IllegalArgumentException('directory must not be null')
        if (transformation == null) throw new IllegalArgumentException('transformation must not be null')
        if (validation == null) throw new IllegalArgumentException('validation must not be null')
        if (output == null) throw new IllegalArgumentException('output must not be null')
        return new ExciteBuilder(directory, transformation, validation, output)
    }

    /**
     * @return {@code IExciteFacade} an instance of {@link Excite}
     */
    private static IExciteFacade facade() {
        return new ExciteFacadeImpl()
    }

    @groovy.transform.PackageScope
    static IExciteFacade facadeWith(IMarkupTransformer markupTransformer,
                                     IFileSystemService fileSystemService,
                                     IFileParser fileParser) {
        return new ExciteFacadeImpl(markupTransformer, fileSystemService, fileParser)
    }

}
