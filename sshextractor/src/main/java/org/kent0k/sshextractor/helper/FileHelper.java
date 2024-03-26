package org.kent0k.sshextractor.helper;

import org.kent0k.sshextractor.exception.SshExtractorException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileHelper {

    /**
     * Check whether directory and at least one file in there also exists.
     *
     * @param path path where need to create directory.
     * @return boolean flag return true where directory already exists and filled with at least one file.
     */
    public boolean isDirectoryExistsAndFilled(Path path) {
        if (Files.exists(path) && isFilesContainsBy(path)) {
            return true;
        }

        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                return false;
            } catch (IOException e) {
                throw new SshExtractorException(String.format("Exception during create new directory by %s", path), e.getCause());
            }
        }
        return false;
    }

    /**
     * Build list of file names by specific directory.
     *
     * @param directoryPath directory path using by {@link Path}.
     * @return list of file names.
     */
    public List<String> fetchFileNamesBySpecificDirectory(Path directoryPath) {
        try (Stream<Path> stream = Files.list(directoryPath)) {
            List<String> fileNames = gatherFileNamesBy(stream);

            if (fileNames.isEmpty()) {
                throw new SshExtractorException(String.format("None file names fetched from %s", directoryPath.toAbsolutePath()));
            }

            return fileNames;
        } catch (IOException e) {
            throw new SshExtractorException(String.format("Exception during fetch file names from %s", directoryPath.toAbsolutePath()), e.getCause());
        }
    }

    /**
     * Check whether passed directory path has none of files.
     *
     * @param directoryPath directory path using by {@link Path}.
     * @return boolean flag is passed directory path has none of files.
     */
    boolean isFilesContainsBy(Path directoryPath) {
        try (Stream<Path> stream = Files.list(directoryPath)) {
            return !gatherFileNamesBy(stream).isEmpty();
        } catch (IOException e) {
            throw new SshExtractorException(String.format("Exception during fetch file names from %s", directoryPath.toAbsolutePath()), e.getCause());
        }
    }

    /**
     * Fetch file names by passed stream of path.
     *
     * @param stream stream of entries in specific directory.
     * @return list of file names.
     */
    List<String> gatherFileNamesBy(Stream<Path> stream) {
        return stream
                .filter(file -> !Files.isDirectory(file))
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
    }
}
