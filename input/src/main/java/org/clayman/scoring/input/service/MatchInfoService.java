package org.clayman.scoring.input.service;

import org.clayman.scoring.common.cassandra.entity.PlayerStatsByPlayerId;
import org.clayman.scoring.input.repository.MatchInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchInfoService {

    @Autowired
    private MatchInfoRepository matchInfoRepository;

    public void save(PlayerStatsByPlayerId playerStatsByPlayerId) {
        matchInfoRepository.save(playerStatsByPlayerId);
    }
}
