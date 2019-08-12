package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.internal.transformer.operation.GPathResultTransformer
import groovy.util.slurpersupport.GPathResult

/**
 * {@inheritDoc}
 * <p>
 * Transformation Algorithm for Renaming a Child Node
 *
 * @version 1.0.1
 * @since 1.0.1
 */
class DeleteChildNodeByNameTransformation implements ITransformationAlgorithm {

    private final String name

    /**
     * Default Constructor
     * @param oldName the existing name of the node to be replaced
     * @param newName the name to replace the given old name with
     */
    DeleteChildNodeByNameTransformation(final String name) {
        this.name = name
    }

    /**
     * {@inheritDoc}
     * @version 1.0.1
     * @since 1.0.1
     */
    @Override
    void execute(GPathResult node) {
        GPathResultTransformer.deleteChildNodesWithName(node, this.name)
    }

}
