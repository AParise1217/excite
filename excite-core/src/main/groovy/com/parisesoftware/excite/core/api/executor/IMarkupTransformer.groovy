package com.parisesoftware.excite.core.api.executor

import groovy.xml.slurpersupport.GPathResult

/**
 * Markup Transformer Abstraction
 * <p>
 * Delegation to handle the serialization of XML Markup
 *
 * @version 1.0.2
 * @since 1.0.0
 */
interface IMarkupTransformer {

    /**
     * Serializes the given XML node to a string representation
     * @version 1.0.2
     * @param node the GPathResult to serialize
     * @return {@code String} representation of the node
     * @since 1.0.2
     */
    String serialize(GPathResult node)

}
