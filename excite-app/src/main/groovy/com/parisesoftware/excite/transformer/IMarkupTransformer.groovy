package com.parisesoftware.excite

import groovy.util.slurpersupport.GPathResult

/**
 * Delegation to handle the transformation of XML Markup
 */
interface IMarkupTransformer {

    /**
     * Transforms the given Input Component using the given Transformation Algo and returns the updated Schema
     * @param theInputComponent
     * @param aTransformationAlgorithm
     * @return {@code String} representation of the Transformed Component
     */
    String transform(GPathResult theInputComponent, Closure<GPathResult> aTransformationAlgorithm)

}
