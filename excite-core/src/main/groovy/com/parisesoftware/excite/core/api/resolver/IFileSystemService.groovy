package com.parisesoftware.excite.core.api.resolver

import java.io.IOException
import java.util.function.Predicate
import java.util.stream.Stream

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

    default List<File> getFilesInDirectory(final String aFilePath) {
        return getFilesInDirectory(aFilePath, com.parisesoftware.excite.core.internal.parser.FilePredicate.isXmlFile)
    }

    default Stream<File> streamFilesInDirectory(final String aFilePath, final Predicate<File> isApplicableFile) {
        try {
            return java.nio.file.Files.walk(java.nio.file.Paths.get(aFilePath))
                .filter { java.nio.file.Path p -> java.nio.file.Files.isRegularFile(p) }
                .map { java.nio.file.Path p -> p.toFile() }
                .filter { File f -> isApplicableFile.test(f) }
        } catch (IOException e) {
            throw new com.parisesoftware.excite.core.api.ExciteException("Failed to stream directory: ${aFilePath}", e)
        }
    }

}
