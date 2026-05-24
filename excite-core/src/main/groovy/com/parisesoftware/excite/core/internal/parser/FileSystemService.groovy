package com.parisesoftware.excite.core.internal.parser

import com.parisesoftware.excite.core.api.ExciteException
import com.parisesoftware.excite.core.api.resolver.IFileSystemService
import groovy.io.FileType
import org.slf4j.Logger
import org.slf4j.LoggerFactory

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

    private static final Logger log = LoggerFactory.getLogger(FileSystemService)

    /**
     * {@inheritDoc}
     */
    @Override
    List<File> getFilesInDirectory(final String aFilePath, final Predicate<File> isApplicableFile = FilePredicate.isXmlFile) {
        log.debug('Scanning directory: {}', aFilePath)
        List<File> filesInDirectory = []

        File parentDirectory = new File(aFilePath)
        if (!parentDirectory.exists() || !parentDirectory.isDirectory()) {
            log.error('Directory does not exist or is not readable: {}', aFilePath)
            throw new ExciteException("Directory does not exist or is not readable: ${aFilePath}")
        }
        parentDirectory.eachFileRecurse(FileType.FILES) { final File curFile ->
            if (isApplicableFile.test(curFile)) {
                filesInDirectory << curFile
            }
        }

        log.info('Found {} XML file(s) in: {}', filesInDirectory.size(), aFilePath)
        return filesInDirectory
    }

}
