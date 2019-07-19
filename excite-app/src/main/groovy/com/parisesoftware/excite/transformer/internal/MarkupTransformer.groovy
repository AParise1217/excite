package com.parisesoftware.excite.transformer.internal

import com.parisesoftware.excite.transformer.IMarkupTransformer
import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IMarkupTransformer}
 */
class MarkupTransformer implements IMarkupTransformer {

    private static final String UTF_8_ENCODING = 'UTF-8'

    /**
     * {@inheritDoc}
     */
    @Override
    String transform(GPathResult theInputComponent, Closure aTransformationAlgorithm) {
        StreamingMarkupBuilder builder = new StreamingMarkupBuilder()
        builder.encoding = UTF_8_ENCODING

        def xml = builder.bind {
            it.mkp.yieldUnescaped aTransformationAlgorithm.call(builder, theInputComponent)
        }

        return xml.toString()
    }

}
