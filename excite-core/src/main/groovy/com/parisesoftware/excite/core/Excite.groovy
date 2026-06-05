package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.api.IExciteFacade
import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ITransformationAlgorithm
import com.parisesoftware.excite.core.api.IValidationAlgorithm
import com.parisesoftware.excite.core.api.executor.IMarkupTransformer
import com.parisesoftware.excite.core.api.resolver.IFileParser
import com.parisesoftware.excite.core.api.resolver.IFileSystemService
import com.parisesoftware.excite.core.internal.ExciteFacadeImpl

class Excite {

    static ExciteBuilder builder(String directory,
                                  ITransformationAlgorithm transformation,
                                  IValidationAlgorithm validation,
                                  IOutputCommand output) {
        if (directory == null) throw new IllegalArgumentException('directory must not be null')
        if (transformation == null) throw new IllegalArgumentException('transformation must not be null')
        if (validation == null) throw new IllegalArgumentException('validation must not be null')
        if (output == null) throw new IllegalArgumentException('output must not be null')
        return new ExciteBuilder(directory, transformation, validation, output)
    }

    @groovy.transform.PackageScope
    static IExciteFacade facadeWith(IMarkupTransformer markupTransformer,
                                     IFileSystemService fileSystemService,
                                     IFileParser fileParser) {
        return new ExciteFacadeImpl(markupTransformer, fileSystemService, fileParser)
    }
}
