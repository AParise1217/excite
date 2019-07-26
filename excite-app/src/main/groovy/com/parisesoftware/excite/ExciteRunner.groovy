package com.parisesoftware.excite

import com.parisesoftware.excite.output.OutputMethod
import com.parisesoftware.excite.transformer.operation.GPathResultTransformer
import groovy.util.slurpersupport.GPathResult
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

import java.util.function.Predicate

/**
 * Main Method Runner to Demo a Sample Usage of EXCITE
 */
class ExciteRunner {

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
