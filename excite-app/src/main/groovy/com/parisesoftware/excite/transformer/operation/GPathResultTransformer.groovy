package com.parisesoftware.excite.transformer.operation

import groovy.util.slurpersupport.GPathResult

/**
 * GPathResult Transformer
 * <p>
 * Common Transformations to Perform on {@link GPathResult}s
 *
 * @version 1.0
 * @since 1.0
 */
class GPathResultTransformer {

    /**
     * Deletes all the child nodes on the given Component with a name matching the given Name
     * @param aComponent to have it's nodes checked and deleted
     * @param aName of the Nodes to be deleted
     */
    static void deleteChildNodesWithName(GPathResult aComponent, final String aName) {
        aComponent.children().findAll { GPathResult curChild -> curChild.name() == aName }.replaceNode {}
    }

}
