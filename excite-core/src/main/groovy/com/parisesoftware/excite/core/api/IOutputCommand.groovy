package com.parisesoftware.excite.core.api

/**
 * Output Command
 * <p>
 * Encapsulation of the work needed to output the resultant of an Excite Transformation
 * @version 1.0.1
 * @since 1.0.1
 */
interface IOutputCommand {

    /**
     * Executes the Output Command
     * @version 1.0.1
     * @param initialFile the base, unmodified File that was the input for the Excite Transformation
     * @param transformedContent the resultant of the successful Excite Transformation
     * @since 1.0.1
     */
    void execute(File initialFile, String transformedContent)

}