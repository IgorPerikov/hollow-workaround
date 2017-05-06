package org.clayman.scoring.input.service;

import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;
import org.clayman.scoring.common.cassandra.repository.PlayerProfileByPlayerIdRepository;
import org.clayman.scoring.common.dto.input.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerProfileByPlayerIdRepository repository;

    public Player registerNewPlayer(Player player) {
        player.setPlayerId(UUID.randomUUID());

        PlayerProfileByPlayerId profile = new PlayerProfileByPlayerId();
        profile.setNickname(player.getNickname());
        profile.setPlayerId(player.getPlayerId());
        profile.setRatingPoints(0);
        repository.save(profile);

        return player;
    }
}
