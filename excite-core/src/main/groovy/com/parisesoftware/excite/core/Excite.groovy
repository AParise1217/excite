package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.api.IExciteFacade
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.internal.ExciteFacadeImpl

/**
 * Excite Facade
 *
 * <p>
 * Static Entry-point to the Excite Domain
 *
 * @version 1.0.2
 * @since 1.0.0
 */
class Excite {

    /**
     * Runs the Excite Application Against the given parameters
     * @param aDirectory to scan for potential files
     * @param aTransformationAlgorithm to perform on the files that pass the validation
     * @param aValidationAlgorithm to filter the discovered files in the given directory
     * @param anOutputCommand to handle exporting the resultant transformed content
     */
    static void run(final String aDirectory, final ITransformationAlgorithm aTransformationAlgorithm,
                    final IValidationAlgorithm aValidationAlgorithm, final IOutputCommand anOutputCommand) {
        facade().run(aDirectory, aTransformationAlgorithm, aValidationAlgorithm, anOutputCommand)
    }

    /**
     * @return {@code IExciteFacade} an instance of {@link Excite}
     */
    private static IExciteFacade facade() {
        return new ExciteFacadeImpl()
    }

}
