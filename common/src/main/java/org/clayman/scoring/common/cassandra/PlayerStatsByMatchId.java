package org.clayman.scoring.common.cassandra;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class PlayerStatsByMatchId {
    private UUID playerId;
    private UUID matchId;
    private Integer ratingPointsGained;
    private Integer kills;
    private Integer deaths;
    private Instant startTime;
    private AdditionalMatchInfoUDT additionalInfo;
}
