package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.IValidationAlgorithm
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 * @version 1.0.1
 * @since 1.0.1
 */
class ChildNodeHasValueValidation implements IValidationAlgorithm {

    private final String childNodeName

    private final String childNodeValue

    /**
     * Default Constructor
     * @param childNodeName to check the value for
     * @param childNodeValue to assert that the actual value is equal to
     */
    ChildNodeHasValueValidation(final String childNodeName, final String childNodeValue) {
        this.childNodeName = childNodeName
        this.childNodeValue = childNodeValue
    }

    /**
     * {@inheritDoc}
     * @version 1.0.1
     * @since 1.0.1
     */
    boolean validate(GPathResult node) {
        return node[this.childNodeName] == this.childNodeValue
    }

}
