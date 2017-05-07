package org.clayman.scoring.common.hollow.producer;

import java.io.File;

public interface Publisher {

    void publishSnapshot(File snapshotFile, long stateVersion) throws Exception;
}
