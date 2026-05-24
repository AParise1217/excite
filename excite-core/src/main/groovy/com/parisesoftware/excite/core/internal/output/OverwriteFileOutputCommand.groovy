package com.parisesoftware.excite.core.internal.output

import com.parisesoftware.excite.core.api.IOutputCommand
import com.parisesoftware.excite.core.api.ExciteException
import java.io.IOException

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
        File tempFile = File.createTempFile('excite-', '.tmp', initialFile.parentFile)
        try {
            tempFile.setText(transformedContent, 'UTF-8')
            tempFile.renameTo(initialFile)
        } catch (IOException e) {
            tempFile.delete()
            throw new ExciteException("Failed to write file: ${initialFile.absolutePath}", e)
        }
    }

}
