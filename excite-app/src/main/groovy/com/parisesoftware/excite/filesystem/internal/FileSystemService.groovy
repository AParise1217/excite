package com.parisesoftware.excite

import groovy.io.FileType

import java.util.function.Predicate

/**
 * {@inheritDoc}
 *
 * Default implementation of {@link IFileSystemService}
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
