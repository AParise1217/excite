package com.parisesoftware.excite.internal

import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * Core Abstraction for Excite Application Logic
 */
interface IExciteFacade {

    /**
     * Runs EXCITE on the given Directory
     * @param aDirectory to Scan for XML files
     * @param aTransformationAlgorithm to execute on the files
     * @param aValidationAlgorithm to validate to check if the File is applicable for transformation
     * @param anOutputAlgorithm to be executed with the transformed content
     */
    void run(final String aDirectory,
             final Closure aTransformationAlgorithm,
             final Predicate<GPathResult> aValidationAlgorithm,
             final Closure anOutputAlgorithm)

}
