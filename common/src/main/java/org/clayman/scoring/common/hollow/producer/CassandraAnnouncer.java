package org.clayman.scoring.common.hollow.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clayman.scoring.common.cassandra.repository.HollowStateAnnouncementRepository;

@RequiredArgsConstructor
@Slf4j
public class CassandraAnnouncer implements Announcer {

    private final HollowStateAnnouncementRepository repository;

    @Override
    public void announce(long stateVersion) {
        log.info("Announcing new state={}", stateVersion);
        repository.announceNewState(stateVersion);
    }
}
