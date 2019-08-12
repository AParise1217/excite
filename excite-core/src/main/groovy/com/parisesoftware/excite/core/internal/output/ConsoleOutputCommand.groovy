package com.parisesoftware.excite.core.internal.output

import com.parisesoftware.excite.core.api.IOutputCommand

/**
 * {@inheritDoc}
 * <p>
 * Handler for writing the Output to the Console
 * @version 1.0.1
 * @since 1.0.1
 */
class ConsoleOutputCommand implements IOutputCommand {

    /**
     * {@inheritDoc}
     * @version 1.0.1
     * @since 1.0.1
     */
    void execute(File initialFile, String transformedContent) {
        println transformedContent
    }

}
