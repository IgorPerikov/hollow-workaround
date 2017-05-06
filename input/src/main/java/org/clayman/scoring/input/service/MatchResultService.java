package org.clayman.scoring.input.service;

import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByMatchId;
import org.clayman.scoring.common.cassandra.repository.PlayerProfileByPlayerIdRepository;
import org.clayman.scoring.common.cassandra.repository.PlayerStatsByMatchIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchResultService {

    @Autowired
    private PlayerStatsByMatchIdRepository repository;

    @Autowired
    private PlayerProfileByPlayerIdRepository profileRepository;

    public void save(List<PlayerStatsByMatchId> stats) {
        saveStats(stats);
        updateProfileRatingPoints(stats);
    }

    private void saveStats(List<PlayerStatsByMatchId> stats) {
        // TODO: for simplicity
        stats.forEach(repository::save);
    }

    // TODO: not safe due to possible application crash during
    private void updateProfileRatingPoints(List<PlayerStatsByMatchId> stats) {
        stats.forEach(stat -> {
            PlayerProfileByPlayerId profile = profileRepository.find(stat.getPlayerId());
            profile.setRatingPoints(profile.getRatingPoints() + stat.getRatingPointsGained());
            profileRepository.save(profile);
        });
    }
}
