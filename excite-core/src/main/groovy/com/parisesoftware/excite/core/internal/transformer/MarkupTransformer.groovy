package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import groovy.xml.slurpersupport.GPathResult
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

    /**
     * {@inheritDoc}
     */
    @Override
    String transform(GPathResult theInputComponent, ITransformationAlgorithm aTransformationAlgorithm) {
        aTransformationAlgorithm.execute(theInputComponent)
        return XmlUtil.serialize(theInputComponent)
    }
}
