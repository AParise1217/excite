package com.parisesoftware.excite.core.api

/**
 * Excite Facade Abstraction
 * <p>
 * Core Abstraction for Excite Application Logic
 *
 * @version 1.0.2
 * @since 1.0.0
 */
interface IExciteFacade {

    /**
     * Runs the Excite Application Against the given parameters
     * @version 1.0.1
     * @param aDirectory to scan for potential files
     * @param aTransformationAlgorithm to perform on the files that pass the validation
     * @param aValidationAlgorithm to filter the discovered files in the given directory
     * @param anOutputCommand to handle exporting the resultant transformed content
     * @since 1.0.1
     */
    void run(final String aDirectory, final ITransformationAlgorithm aTransformationAlgorithm,
             final IValidationAlgorithm aValidationAlgorithm, final IOutputCommand anOutputCommand)

}
