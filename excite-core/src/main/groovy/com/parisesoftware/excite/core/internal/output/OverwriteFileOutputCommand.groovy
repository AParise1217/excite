package com.parisesoftware.excite.core.internal.output

import com.parisesoftware.excite.core.api.IOutputCommand

/**
 * {@inheritDoc}
 * <p>
 * Handler for Overwriting the Existing File with the Transformed Content
 * @version 1.0.1
 * @since 1.0.1
 */
class OverwriteFileOutputCommand implements IOutputCommand {

    /**
     * {@inheritDoc}
     * @version 1.0.1
     * @since 1.0.1
     */
    void execute(File initialFile, String transformedContent) {
        initialFile.newWriter().withWriter { writer ->
            writer << transformedContent
        }
    }

}
