package com.parisesoftware.excite.commandline

import com.parisesoftware.excite.core.Excite
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.internal.output.ConsoleOutputCommand
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
        if (args.length < 1) {
            println 'Usage: ExciteCLIRunner <directory> [console|file]'
            return
        }

        final String parentDirectory = args[0]
        final boolean writeToFile = args.length > 1 && args[1] == 'file'

        final IOutputCommand encapsulatedOutputCommand = writeToFile
            ? new OverwriteFileOutputCommand()
            : new ConsoleOutputCommand()

        final ITransformationAlgorithm encapsulatedTransformation =
            new RenameChildNodeTransformation('description', 'description_html')

        final IValidationAlgorithm encapsulatedValidation =
            new ChildNodeHasValueValidation('content-type', '/component/person')

        Excite.run(parentDirectory, encapsulatedTransformation, encapsulatedValidation, encapsulatedOutputCommand)
    }

}
