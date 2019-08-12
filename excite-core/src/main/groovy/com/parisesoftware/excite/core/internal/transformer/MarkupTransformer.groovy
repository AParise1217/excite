package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IMarkupTransformer}
 *
 * @version 1.0.1
 * @since 1.0.0
 */
class MarkupTransformer implements IMarkupTransformer {

    private static final String UTF_8_ENCODING = 'UTF-8'

    /**
     * {@inheritDoc}
     */
    @Deprecated
    @Override
    String transform(GPathResult theInputComponent, Closure aTransformationAlgorithm) {
        StreamingMarkupBuilder builder = new StreamingMarkupBuilder()
        builder.encoding = UTF_8_ENCODING

        def xml = builder.bind {
            it.mkp.yieldUnescaped aTransformationAlgorithm.call(builder, theInputComponent)
        }

        return xml.toString()
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String transform(GPathResult theInputComponent, ITransformationAlgorithm aTransformationAlgorithm) {
        StreamingMarkupBuilder builder = new StreamingMarkupBuilder()
        builder.encoding = UTF_8_ENCODING

        aTransformationAlgorithm.execute(theInputComponent)

        def xml = builder.bind {
            it.mkp.yieldUnescaped XmlUtil.serialize(theInputComponent)
        }

        return xml.toString()
    }
}
