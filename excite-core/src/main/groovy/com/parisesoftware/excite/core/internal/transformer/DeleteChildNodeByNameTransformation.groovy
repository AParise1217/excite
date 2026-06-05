package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.MutableXmlNode

class DeleteChildNodeByNameTransformation implements ITransformationAlgorithm {

    private final String name

    DeleteChildNodeByNameTransformation(final String name) {
        this.name = name
    }

    @Override
    void execute(MutableXmlNode node) {
        node.deleteChildrenNamed(this.name)
    }
}
