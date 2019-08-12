package com.parisesoftware.excite.core.api

import groovy.util.slurpersupport.GPathResult

/**
 * Transformation Algorithm
 * <p>
 * Encapsulation of some transformation to perform on the given node
 *
 * @version 1.0.1
 * @since 1.0.1
 */
interface ITransformationAlgorithm {

    /**
     * Executes the Transformation
     * @version 1.0.1
     * @param node the target of the transformation
     * @since 1.0.1
     */
    void execute(GPathResult node)

}
