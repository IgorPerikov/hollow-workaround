package org.clayman.scoring.common.cassandra;

import lombok.Data;

import java.util.UUID;

@Data
public class TopRatingPlayer {
    private Integer stub;
    private Integer ratingPoints;
    private UUID playerId;
    private String nickname;
}
