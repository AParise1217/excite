package com.parisesoftware.excite.core.api

import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * Excite Facade Abstraction
 * <p>
 * Core Abstraction for Excite Application Logic
 *
 * @version 1.0.1
 * @since 1.0.0
 */
interface IExciteFacade {

    /**
     * Runs EXCITE on the given Directory
     * @version 1.0.0
     * @param aDirectory to Scan for XML files
     * @param aTransformationAlgorithm to execute on the files
     * @param aValidationAlgorithm to validate to check if the File is applicable for transformation
     * @param anOutputAlgorithm to be executed with the transformed content
     * @since 1.0.0
     */
    @Deprecated
    void run(final String aDirectory,
             final Closure aTransformationAlgorithm,
             final Predicate<GPathResult> aValidationAlgorithm,
             final Closure anOutputAlgorithm)

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
