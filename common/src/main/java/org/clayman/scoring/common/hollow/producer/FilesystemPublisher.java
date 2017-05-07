package org.clayman.scoring.common.hollow.producer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.*;

@RequiredArgsConstructor
public class FilesystemPublisher implements Publisher {

    private final String publishDir;

    @Override
    public void publishSnapshot(File snapshotFile, long stateVersion) throws Exception {
        File publishedFile = new File(publishDir, "snapshot-" + stateVersion);
        copyFile(snapshotFile, publishedFile);
    }

    private void copyFile(File sourceFile, File destFile) {
        try(InputStream is = new FileInputStream(sourceFile); OutputStream os = new FileOutputStream(destFile)) {
            IOUtils.copy(is, os);
        } catch(IOException e) {
            throw new RuntimeException("Unable to publish file!", e);
        }
    }
}
