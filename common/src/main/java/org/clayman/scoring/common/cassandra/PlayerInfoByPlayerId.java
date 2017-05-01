package org.clayman.scoring.common.cassandra;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class PlayerInfoByPlayerId {
    private UUID playerId;
    private Integer ratingPoints;
    private Instant ratingLastUpdateTime;
    private String nickname;

    /**
     * only needed for support top_players table
     */
    private final Integer stub = 0;
}
