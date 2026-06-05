package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.XmlNode

import java.util.function.Predicate

class ValidationMethod {

    static final Predicate<XmlNode> ACCEPT_ALL = { XmlNode aComponent ->
        return new AcceptAllValidation().validate(aComponent)
    }
}
