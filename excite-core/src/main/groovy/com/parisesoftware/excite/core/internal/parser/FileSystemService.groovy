package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.resolver.IFileSystemService
import groovy.io.FileType

import java.util.function.Predicate

/**
 * {@inheritDoc}
 * <p>
 * Default implementation of {@link IFileSystemService}
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class FileSystemService implements IFileSystemService {

    /**
     * {@inheritDoc}
     */
    @Override
    List<File> getFilesInDirectory(final String aFilePath, final Predicate<File> isApplicableFile = FilePredicate.isXmlFile) {
        List<File> filesInDirectory = []

        File parentDirectory = new File(aFilePath)
        parentDirectory.eachFileRecurse(FileType.FILES) { final File curFile ->
            if (isApplicableFile.test(curFile)) {
                filesInDirectory << curFile
            }
        }

        return filesInDirectory
    }

}
