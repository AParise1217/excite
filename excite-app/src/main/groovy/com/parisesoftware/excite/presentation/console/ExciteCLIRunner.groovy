package com.parisesoftware.excite.presentation.console

import com.parisesoftware.excite.core.ExciteFacade
import com.parisesoftware.excite.core.transformer.operation.GPathResultTransformer
import com.parisesoftware.excite.infrastructure.output.OutputMethod
import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

import java.util.function.Predicate

/**
 * Main Method Runner to Demo a Sample Usage of EXCITE
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class ExciteCLIRunner {

    static void main(String[] args) {

        final Closure transformationAlgorithm = { StreamingMarkupBuilder builder, GPathResult aComponent ->
            GPathResultTransformer.deleteChildNodesWithName(aComponent, 'callout')
            return XmlUtil.serialize(aComponent)
        }

        final Predicate<GPathResult> validationAlgorithm = { GPathResult aComponent ->
            return aComponent['content-type'] == '/component/level-descriptor'
        }

        final String parentDirectory = '/Users/aparise/Projects/craftercms/crafter-authoring/data/repos/sites/pennmutualcom/sandbox/site/'

        ExciteFacade.run(parentDirectory, transformationAlgorithm, validationAlgorithm, OutputMethod.FILE)
    }

}
