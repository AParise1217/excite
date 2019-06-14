package com.parisesoftware.excite.transformer.internal

import com.parisesoftware.excite.transformer.IMarkupTransformer
import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IMarkupTransformer}
 */
class MarkupTransformer implements IMarkupTransformer {

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"

    /**
     * {@inheritDoc}
     */
    @Override
    String transform(GPathResult theInputComponent, Closure aTransformationAlgorithm) {
        StringWriter writer = new StringWriter()
        MarkupBuilder builder = new MarkupBuilder(writer)

        builder.component() {
            aTransformationAlgorithm.call(builder, theInputComponent)
        }

        return XML_HEADER + writer.toString()
    }

}
