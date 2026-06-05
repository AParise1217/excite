package com.parisesoftware.excite.core.internal.validation

import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.api.XmlNode

class ChildNodeHasValueValidation implements IValidationAlgorithm {

    private final String childNodeName
    private final String childNodeValue

    ChildNodeHasValueValidation(final String childNodeName, final String childNodeValue) {
        this.childNodeName = childNodeName
        this.childNodeValue = childNodeValue
    }

    boolean validate(XmlNode node) {
        if (node == null) return false
        return node.getChildText(this.childNodeName)
                   .map { it == this.childNodeValue }
                   .orElse(false)
    }
}
