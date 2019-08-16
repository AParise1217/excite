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
 * @version 1.0.2
 * @since 1.0.0
 */
class MarkupTransformer implements IMarkupTransformer {

    private static final String UTF_8_ENCODING = 'UTF-8'

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
