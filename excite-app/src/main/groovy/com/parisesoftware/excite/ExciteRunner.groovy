package com.parisesoftware.excite

import com.parisesoftware.excite.internal.ExciteFacade
import com.parisesoftware.excite.output.OutputMethod
import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

import java.util.function.Predicate

/**
 * Main Method Runner to Demo a Sample Usage of EXCITE
 */
class ExciteRunner {

    static void main(String[] args) {

        final Closure transformationAlgorithm = { MarkupBuilder builder, GPathResult aComponent ->
            builder.'content-type'("${aComponent['content-type']}")
            builder.'display-template'("${aComponent['display-template']}")
            builder.'merge-strategy'("${aComponent['merge-strategy']}")
            builder.'objectGroupId'("${aComponent['objectGroupId']}")
            builder.'objectId'("${aComponent['objectId']}")
            builder.'file-name'("${aComponent['file-name']}")
            builder.'internal-name'("${aComponent['internal-name']}")
            builder.'altText'("${aComponent['altText']}")
            builder.'image'("${aComponent['image']}")
            builder.'imageMobile'("${aComponent['imageMobile']}")
            builder.'title_html'("${aComponent['title_html']}")
            builder.'content_html'("${aComponent['content_html']}")
            builder.'createdDate'("${aComponent['createdDate']}")
            builder.'createdDate_dt'("${aComponent['createdDate_dt']}")
            builder.'lastModifiedDate'("${aComponent['lastModifiedDate']}")
            builder.'lastModifiedDate_dt'("${aComponent['lastModifiedDate_dt']}")
            builder.'label'("${aComponent['label']}")
            builder.'url'("${aComponent['url']}")
            builder.'button'() {
                'label'("${aComponent['label']}")
                'url'("${aComponent['url']}")
            }
        }

        final Predicate<GPathResult> validationAlgorithm = { GPathResult aComponent ->
            return aComponent['content-type'] == '/component/card'
        }

        final String parentDirectory = '/Users/aparise/Projects/craftercms/crafter-authoring/data/repos/sites/pennmutualcom/sandbox/site/test/'

        new ExciteFacade().run(parentDirectory, transformationAlgorithm, validationAlgorithm, OutputMethod.FILE)
    }

}
