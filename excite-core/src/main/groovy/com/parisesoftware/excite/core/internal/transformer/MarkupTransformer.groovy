package com.parisesoftware.excite.core.internal.transformer

import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import groovy.xml.slurpersupport.GPathResult
import groovy.xml.XmlUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IMarkupTransformer}
 *
 * @version 1.0.2
 * @since 1.0.0
 */
class MarkupTransformer implements IMarkupTransformer {

    private static final Logger log = LoggerFactory.getLogger(MarkupTransformer)

    /**
     * {@inheritDoc}
     */
    @Override
    String transform(GPathResult theInputComponent, ITransformationAlgorithm aTransformationAlgorithm) {
        log.debug('Transforming markup')
        aTransformationAlgorithm.execute(theInputComponent)
        return XmlUtil.serialize(theInputComponent)
    }
}
