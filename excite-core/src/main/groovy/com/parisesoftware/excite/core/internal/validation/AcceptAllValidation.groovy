package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.IValidationAlgorithm
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 * @version 1.0.1
 * @since 1.0.1
 */
class AcceptAllValidation implements IValidationAlgorithm {

    /**
     * {@inheritDoc}
     * @version 1.0.1
     * @since 1.0.1
     */
    boolean validate(GPathResult node) {
        return node != null
    }

}
