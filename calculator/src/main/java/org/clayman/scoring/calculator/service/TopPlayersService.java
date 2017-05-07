package org.clayman.scoring.calculator.service;

import com.netflix.hollow.api.producer.fs.HollowFilesystemAnnouncer;
import com.netflix.hollow.api.producer.fs.HollowFilesystemPublisher;
import com.netflix.hollow.core.write.HollowBlobWriter;
import com.netflix.hollow.core.write.HollowWriteStateEngine;
import com.netflix.hollow.core.write.objectmapper.HollowObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.clayman.scoring.common.cassandra.entity.TopRatingPlayer;
import org.clayman.scoring.common.cassandra.repository.TopRatingPlayersRepository;
import org.clayman.scoring.common.hollow.entity.HollowTopRatingPlayer;
import org.clayman.scoring.common.hollow.producer.Announcer;
import org.clayman.scoring.common.hollow.producer.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TopPlayersService {

    @Value("${hollow.snapshot.folder}")
    private static String folderDestination;

    @Autowired
    private TopRatingPlayersRepository repository;

    @Autowired
    private HollowWriteStateEngine writeEngine;

    @Autowired
    private Publisher publisher;

    @Autowired
    private Announcer announcer;

    @Scheduled(fixedDelay = 5 * 1000)
    private void updateTopPlayers() {
        log.info("Updating top players");
        List<TopRatingPlayer> topPlayers = repository.getTopPlayers();

        List<HollowTopRatingPlayer> hollowTopPlayers = topPlayers.stream().map(player -> {
            return new HollowTopRatingPlayer(player.getPlayerId(), player.getRatingPoints(), player.getNickname());
        }).collect(Collectors.toList());


        try {
            HollowObjectMapper mapper = new HollowObjectMapper(writeEngine);
            writeEngine.prepareForNextCycle();
            mapper.add(hollowTopPlayers);

            writeEngine.prepareForWrite();

            Long stateVersion = Instant.now().toEpochMilli();

            File file = new File(folderDestination, "-" + stateVersion);

            HollowBlobWriter writer = new HollowBlobWriter(writeEngine);
            try (OutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
                writer.writeSnapshot(os);
            }

            publisher.publishSnapshot(file, stateVersion);
            announcer.announce(stateVersion);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            writeEngine.resetToLastPrepareForNextCycle();
        }

        log.info("Complete updating top players");
    }
}
