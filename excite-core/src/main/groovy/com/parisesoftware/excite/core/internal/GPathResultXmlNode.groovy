package com.parisesoftware.excite.core.internal

import com.parisesoftware.excite.core.api.MutableXmlNode
import com.parisesoftware.excite.core.internal.transformer.operation.GPathResultTransformer
import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult

/**
 * GPathResultXmlNode
 * <p>
 * Internal implementation of {@link MutableXmlNode} that wraps a Groovy {@link GPathResult}.
 * Adapts the GPathResult API to the XmlNode/MutableXmlNode interfaces, keeping GPathResult
 * out of the public API surface.
 *
 * @version 1.1.0
 * @since 1.1.0
 */
class GPathResultXmlNode implements MutableXmlNode {

    private final GPathResult node

    GPathResultXmlNode(GPathResult node) {
        this.node = node
    }

    @Override
    String getName() {
        return node.name()
    }

    @Override
    String getText() {
        return node.text()
    }

    @Override
    Optional<String> getChildText(String name) {
        def child = currentNode().children().find { it.name() == name }
        return child ? Optional.of(child.text()) : Optional.empty()
    }

    @Override
    boolean hasChild(String name) {
        return currentNode().children().any { it.name() == name }
    }

    @Override
    Optional<String> getAttribute(String name) {
        String value = node["@${name}"].text()
        return value ? Optional.of(value) : Optional.empty()
    }

    @Override
    void renameChildrenNamed(String oldName, String newName) {
        GPathResultTransformer.renameChildNodesWithName(node, oldName, newName)
    }

    @Override
    void deleteChildrenNamed(String name) {
        GPathResultTransformer.deleteChildNodesWithName(node, name)
    }

    @Override
    void addChild(String name, String value) {
        throw new UnsupportedOperationException('addChild will be implemented in Wave D')
    }

    @Override
    void setValue(String value) {
        throw new UnsupportedOperationException('setValue will be implemented in Wave D')
    }

    @Override
    void setAttribute(String name, String value) {
        throw new UnsupportedOperationException('setAttribute will be implemented in Wave D')
    }

    @Override
    void renameAttribute(String oldName, String newName) {
        throw new UnsupportedOperationException('renameAttribute will be implemented in Wave D')
    }

    /**
     * Returns the underlying GPathResult for use by internal components (e.g. MarkupTransformer).
     * Not part of the public API.
     * @return the wrapped GPathResult
     */
    GPathResult getGPathResult() {
        return node
    }

    /**
     * Returns a fresh GPathResult reflecting any pending mutations (replaceNode etc.).
     * GPathResult's children() is read from the raw Node.children list and does not reflect
     * replacementNodeStack mutations until serialization. Re-parsing via XmlUtil.serialize
     * gives a consistent post-mutation view for read operations.
     */
    private GPathResult currentNode() {
        String serialized = XmlUtil.serialize(node)
        return new XmlSlurper().parseText(serialized)
    }
}
