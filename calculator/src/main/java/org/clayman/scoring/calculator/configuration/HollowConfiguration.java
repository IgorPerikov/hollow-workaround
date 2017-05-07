package org.clayman.scoring.calculator.configuration;

import com.netflix.hollow.core.write.HollowWriteStateEngine;
import org.clayman.scoring.common.cassandra.repository.HollowStateAnnouncementRepository;
import org.clayman.scoring.common.hollow.producer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;

@Configuration
public class HollowConfiguration {

    @Bean
    @Profile("development")
    public Publisher filesystemPublisher(@Value("${hollow.snapshot.folder}") String dir) {
        new File(dir).mkdirs();
        return new FilesystemPublisher(dir);
    }

    @Bean
    @Profile("production")
    public Publisher s3Publisher() {
        return new S3Publisher();
    }

    @Bean
    public Announcer announcer(HollowStateAnnouncementRepository repository) {
        return new CassandraAnnouncer(repository);
    }

    @Bean
    public HollowWriteStateEngine hollowWriteStateEngine() {
        return new HollowWriteStateEngine();
    }
}
