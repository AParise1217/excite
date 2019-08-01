package com.parisesoftware.excite.core.transformer.internal

import com.parisesoftware.excite.core.transformer.IMarkupTransformer
import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IMarkupTransformer}
 *
 * @version 1.0.0
 * @since 1.0.0
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
