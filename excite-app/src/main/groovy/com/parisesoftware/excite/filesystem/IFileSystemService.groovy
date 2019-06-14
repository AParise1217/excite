package com.parisesoftware.excite.filesystem

import java.util.function.Predicate

/**
 * Service Tier Abstraction for Calls Against the File System
 */
interface IFileSystemService {

    /**
     * Fetch all the Files in the given Directory
     * @param aFilePath to a Parent Directory to Scan
     * @param isApplicableFile {@link Predicate} to validate the Files found
     * @return {@code List} of {@link File}s found in the Directory
     */
    List<File> getFilesInDirectory(final String aFilePath, final Predicate<File> isApplicableFile)

}
