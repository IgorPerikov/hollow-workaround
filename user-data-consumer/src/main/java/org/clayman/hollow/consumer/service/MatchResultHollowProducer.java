package org.clayman.hollow.consumer.service;

import com.netflix.hollow.core.write.HollowBlobWriter;
import com.netflix.hollow.core.write.HollowWriteStateEngine;
import com.netflix.hollow.core.write.objectmapper.HollowObjectMapper;
import org.clayman.hollow.common.data.MatchResult;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.Instant;

@Service
public class MatchResultHollowProducer {

    private static final String SCRATCH_DIR = System.getProperty("java.io.tmpdir");

    private HollowWriteStateEngine writeEngine;
    private HollowObjectMapper mapper;

    @PostConstruct
    private void init() {
        writeEngine = new HollowWriteStateEngine();
        mapper = new HollowObjectMapper(writeEngine);
    }

    public void store(MatchResult matchResult) {
        File snapshotFile = new File(SCRATCH_DIR, "snapshot-" + Instant.now());

        mapper.add(matchResult);
        OutputStream os = new BufferedOutputStream(new FileOutputStream(snapshotFile));
        HollowBlobWriter writer = new HollowBlobWriter(writeEngine);
        writer.writeSnapshot(os);
    }
}
