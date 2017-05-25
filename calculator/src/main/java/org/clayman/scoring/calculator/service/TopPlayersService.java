package org.clayman.scoring.calculator.service;

import lombok.extern.slf4j.Slf4j;
import org.clayman.scoring.common.cassandra.entity.TopRatingPlayer;
import org.clayman.scoring.common.cassandra.repository.TopRatingPlayersRepository;
import org.clayman.scoring.common.hollow.entity.HollowTopRatingPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TopPlayersService {

    @Autowired
    private TopRatingPlayersRepository repository;

    @Scheduled(fixedDelay = 5 * 1000)
    private void updateTopPlayers() {
        log.info("Updating top players");
        List<TopRatingPlayer> topPlayers = repository.getTopPlayers();

        List<HollowTopRatingPlayer> hollowTopPlayers = topPlayers.stream()
                .map(HollowTopRatingPlayer::new)
                .collect(Collectors.toList());


        // TODO: publish top players


        log.info("Complete updating top players");
    }
}
