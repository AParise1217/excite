package com.parisesoftware.excite.core.internal.transformer.operation

import groovy.transform.PackageScope
import groovy.util.slurpersupport.GPathResult

/**
 * GPathResult Transformer
 * <p>
 * Common Transformations to Perform on {@link GPathResult}s
 *
 * @version 1.0.1
 * @since 1.0.0
 */
class GPathResultTransformer {

    @PackageScope
    static GPathResult findAllChildrenWithName(GPathResult aComponent, final String aName) {
        return aComponent.children().findAll { GPathResult curChild -> curChild.name() == aName }
    }

    /**
     * Deletes all the child nodes on the given Component with a name matching the given Name
     * @version 1.0.1
     * @param aComponent to have it's nodes checked and deleted
     * @param aName of the Nodes to be deleted
     * @since 1.0.0
     */
    static void deleteChildNodesWithName(GPathResult aComponent, final String aName) {
        findAllChildrenWithName(aComponent, aName).replaceNode {}
    }

    /**
     * Renames all the child nodes on the given Component with a name matching the given Old Name
     * @version 1.0.1
     * @param aComponent to have it's nodes checked and renamed
     * @param theOldName of the Nodes to be renamed
     * @param theNewName to be set on the Node
     * @since 1.0.1
     */
    static void renameChildNodesWithName(GPathResult aComponent, final String theOldName, final String theNewName) {
        findAllChildrenWithName(aComponent, theOldName).replaceNode { n ->
            "${theNewName}"( n.text() )
        }
    }

}
