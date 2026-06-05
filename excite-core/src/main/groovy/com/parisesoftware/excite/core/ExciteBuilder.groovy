package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.api.ExciteResult
import com.parisesoftware.excite.core.api.IExciteFacade
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.internal.ExciteFacadeImpl

class ExciteBuilder {

    private final String directory
    private final ITransformationAlgorithm transformation
    private final IValidationAlgorithm validation
    private final IOutputCommand output

    ExciteBuilder(String directory, ITransformationAlgorithm transformation,
                  IValidationAlgorithm validation, IOutputCommand output) {
        this.directory = directory
        this.transformation = transformation
        this.validation = validation
        this.output = output
    }

    ExciteResult run() {
        return facade().run(directory, transformation, validation, output)
    }

    private static IExciteFacade facade() {
        return new ExciteFacadeImpl()
    }
}
