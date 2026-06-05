package com.parisesoftware.excite.core.api

/**
 * MutableXmlNode
 * <p>
 * Mutable extension of XmlNode providing methods to modify XML element nodes.
 * Enables renaming children, deleting children, adding children, and modifying attributes.
 *
 * @version 1.1.0
 * @since 1.1.0
 */
interface MutableXmlNode extends XmlNode {

    /**
     * Renames all child elements matching the given name
     * @version 1.1.0
     * @param oldName the current child element name
     * @param newName the new child element name
     * @since 1.1.0
     */
    void renameChildrenNamed(String oldName, String newName)

    /**
     * Deletes all child elements with the given name
     * @version 1.1.0
     * @param name the child element name to delete
     * @since 1.1.0
     */
    void deleteChildrenNamed(String name)

    /**
     * Adds a new child element with the given name and text value
     * @version 1.1.0
     * @param name the new child element name
     * @param value the text content for the new child
     * @since 1.1.0
     */
    void addChild(String name, String value)

    /**
     * Sets the text content of this node
     * @version 1.1.0
     * @param value the new text content
     * @since 1.1.0
     */
    void setValue(String value)

    /**
     * Sets the value of an attribute
     * @version 1.1.0
     * @param name the attribute name
     * @param value the attribute value
     * @since 1.1.0
     */
    void setAttribute(String name, String value)

    /**
     * Renames an attribute on this node
     * @version 1.1.0
     * @param oldName the current attribute name
     * @param newName the new attribute name
     * @since 1.1.0
     */
    void renameAttribute(String oldName, String newName)

}
