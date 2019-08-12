package com.parisesoftware.excite.core.internal.validation

import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * Validation Method
 * <p>
 * Common Excite Validation Methods to Exemplify System Usage
 *
 * @version 1.0.1
 * @since 1.0.0
 */
class ValidationMethod {

    /**
     * Accepts all Non-Null Components
     */
    static final Predicate<GPathResult> ACCEPT_ALL = { GPathResult aComponent ->
        return new AcceptAllValidation().validate(aComponent)
    }

}
