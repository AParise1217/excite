package com.parisesoftware.excite

/**
 * Core Abstraction for Excite Application Logic
 */
interface IExciteFacade {

    /**
     * Runs EXCITE on the given Directory
     * @param aDirectory to Scan for XML files
     * @param aTransformationAlgorithm to execute on the files
     * @param anOutputAlgorithm to be executed with the transformed content
     */
    void run(String aDirectory, Closure aTransformationAlgorithm, Closure anOutputAlgorithm)

}
