package org.clayman.scoring.common.domain;

import lombok.Data;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Data
public class MatchInfo {
    private UUID id;

    private Map<UUID, PlayerStats> playerStats;

    private Instant startTime;
    private Instant endTime;
    private MatchType matchType;
    private String mapName;
}
