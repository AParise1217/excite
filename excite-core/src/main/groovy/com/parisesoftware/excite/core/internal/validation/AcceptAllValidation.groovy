package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.api.XmlNode

class AcceptAllValidation implements IValidationAlgorithm {
    boolean validate(XmlNode node) {
        return node != null
    }
}
