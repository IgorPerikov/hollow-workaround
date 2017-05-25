package org.clayman.scoring.common.hollow.entity;

import lombok.Getter;
import org.clayman.scoring.common.cassandra.entity.TopRatingPlayer;

import java.util.UUID;

@Getter
public class HollowTopRatingPlayer {

    public HollowTopRatingPlayer(TopRatingPlayer player) {
        this.playerId = player.getPlayerId();
        this.ratingPoints = player.getRatingPoints();
        this.nickname = player.getNickname();
    }

    UUID playerId;
    Integer ratingPoints;
    String nickname;
}
