package com.parisesoftware.excite.validation

import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

class ValidationMethod {

    static final Predicate<GPathResult> ACCEPT_ALL = { GPathResult aComponent ->
        aComponent != null
    }

}
