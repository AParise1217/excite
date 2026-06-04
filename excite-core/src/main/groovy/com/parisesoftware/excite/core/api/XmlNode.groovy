package com.parisesoftware.excite.core.api

/**
 * XmlNode
 * <p>
 * Read-only interface representing an XML element node.
 * Provides methods to access element name, text content, child elements, and attributes
 * in a type-safe manner without exposing internal Groovy types like GPathResult.
 *
 * @version 1.1.0
 * @since 1.1.0
 */
interface XmlNode {

    /**
     * Gets the name of this node
     * @version 1.1.0
     * @return the element name (never null)
     * @since 1.1.0
     */
    String getName()

    /**
     * Gets the text content of this node
     * @version 1.1.0
     * @return the text content (never null; empty string if no text)
     * @since 1.1.0
     */
    String getText()

    /**
     * Gets the text content of a named child element
     * @version 1.1.0
     * @param name the child element name
     * @return {@code Optional} containing the child text, or empty if the child does not exist
     * @since 1.1.0
     */
    Optional<String> getChildText(String name)

    /**
     * Checks if this node has a child element with the given name
     * @version 1.1.0
     * @param name the child element name
     * @return true if a child with this name exists; false otherwise
     * @since 1.1.0
     */
    boolean hasChild(String name)

    /**
     * Gets the value of a named attribute
     * @version 1.1.0
     * @param name the attribute name
     * @return {@code Optional} containing the attribute value, or empty if the attribute does not exist
     * @since 1.1.0
     */
    Optional<String> getAttribute(String name)

}
