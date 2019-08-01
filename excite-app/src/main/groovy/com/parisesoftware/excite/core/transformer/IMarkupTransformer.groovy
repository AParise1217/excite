package com.parisesoftware.excite.core.transformer

import groovy.util.slurpersupport.GPathResult

/**
 * Markup Transformer Abstraction
 * <p>
 * Delegation to handle the transformation of XML Markup
 *
 * @version 1.0.0
 * @since 1.0.0
 */
interface IMarkupTransformer {

    /**
     * Transforms the given Input Component using the given Transformation Algo and returns the updated Schema
     * @version 1.0.0
     * @param theInputComponent
     * @param aTransformationAlgorithm
     * @return {@code String} representation of the Transformed Component
     * @since 1.0.0
     */
    String transform(GPathResult theInputComponent, Closure<GPathResult> aTransformationAlgorithm)

}
