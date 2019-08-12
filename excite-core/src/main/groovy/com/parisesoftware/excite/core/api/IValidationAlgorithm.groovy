package com.parisesoftware.excite.core.api

import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder

/**
 * Validation Algorithm
 * <p>
 * Encapsulation of some validation to perform on the given node
 *
 * @version 1.0.1
 * @since 1.0.1
 */
interface IValidationAlgorithm {

    /**
     * Validates the given Node
     * @version 1.0.1
     * @param node to be validated for if the transformation can take place
     * @return {@code boolean} true if this node is valid; false if not
     * @since 1.0.1
     */
    boolean validate(GPathResult node)

}
