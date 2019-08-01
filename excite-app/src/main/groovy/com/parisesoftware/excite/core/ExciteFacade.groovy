package com.parisesoftware.excite.core

import com.parisesoftware.excite.core.internal.IExciteFacade
import com.parisesoftware.excite.core.internal.impl.ExciteFacadeImpl
import groovy.util.slurpersupport.GPathResult

import java.util.function.Predicate

/**
 * Excite Facade
 *
 * <p>
 * Static Entry-point to the Excite Domain
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class ExciteFacade {

    /**
     * Runs the Excite Application Against the given parameters
     * @param aDirectory
     * @param aTransformationAlgorithm
     * @param aValidationAlgorithm
     * @param anOutputAlgorithm
     */
    static void run(final String aDirectory, final Closure aTransformationAlgorithm,
                    final Predicate<GPathResult> aValidationAlgorithm, final Closure anOutputAlgorithm) {
        facade().run(aDirectory, aTransformationAlgorithm, aValidationAlgorithm, anOutputAlgorithm)
    }

    /**
     * @return {@code IExciteFacade} an instance of {@link ExciteFacade}
     */
    private static IExciteFacade facade() {
        return new ExciteFacadeImpl()
    }

}
