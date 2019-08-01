package com.parisesoftware.excite.infrastructure.filesystem

import java.util.function.Predicate

/**
 * File System Service Abstraction
 * <p>
 * Service Tier Abstraction for Calls Against the File System
 *
 * @version 1.0.0
 * @since 1.0.0
 */
interface IFileSystemService {

    /**
     * Fetch all the Files in the given Directory
     * @version 1.0.0
     * @param aFilePath to a Parent Directory to Scan
     * @param isApplicableFile {@link Predicate} to validate the Files found
     * @return {@code List} of {@link File}s found in the Directory
     * @since 1.0.0
     */
    List<File> getFilesInDirectory(final String aFilePath, final Predicate<File> isApplicableFile)

}
