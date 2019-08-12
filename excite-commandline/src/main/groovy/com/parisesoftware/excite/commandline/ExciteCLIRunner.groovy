package com.parisesoftware.excite.commandline

import com.parisesoftware.excite.core.Excite
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.internal.output.OverwriteFileOutputCommand
import com.parisesoftware.excite.core.internal.transformer.RenameChildNodeTransformation
import com.parisesoftware.excite.core.internal.validation.ChildNodeHasValueValidation

/**
 * Main Method Runner to Demo a Sample Usage of EXCITE
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class ExciteCLIRunner {

    static void main(String[] args) {

        final ITransformationAlgorithm encapsulatedTransformation =
                new RenameChildNodeTransformation('description', 'description_html')

        final IValidationAlgorithm encapsulatedValidation =
                new ChildNodeHasValueValidation('content-type', '/component/person')

        final IOutputCommand encapsulatedOutputCommand = new OverwriteFileOutputCommand()

        final String parentDirectory = '/Users/aparise/Projects/craftercms/crafter-authoring/data/repos/sites/pennmutualcom/sandbox/site/'

        Excite.run(parentDirectory, encapsulatedTransformation, encapsulatedValidation, encapsulatedOutputCommand)
    }

}
