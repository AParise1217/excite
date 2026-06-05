package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.MutableXmlNode

class RenameChildNodeTransformation implements ITransformationAlgorithm {

    private final String oldName
    private final String newName

    RenameChildNodeTransformation(final String oldName, final String newName) {
        this.oldName = oldName
        this.newName = newName
    }

    @Override
    void execute(MutableXmlNode node) {
        node.renameChildrenNamed(this.oldName, this.newName)
    }
}
