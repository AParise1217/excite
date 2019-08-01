package com.parisesoftware.excite.core.internal

import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * Excite Facade Abstraction
 * <p>
 * Core Abstraction for Excite Application Logic
 *
 * @version 1.0.0
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
    void run(final String aDirectory,
             final Closure aTransformationAlgorithm,
             final Predicate<GPathResult> aValidationAlgorithm,
             final Closure anOutputAlgorithm)

}