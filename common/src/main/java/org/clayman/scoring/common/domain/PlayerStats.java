package org.clayman.scoring.common.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class PlayerStats {
    private UUID playerId;
    private UUID matchId;
    private Integer ratingPointsGained;
    private Integer kills;
    private Integer deaths;
}
