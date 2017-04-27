package org.clayman.scoring.common.domain;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Data
public class MatchInfo {
    private UUID id;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Map<UUID, PlayerStats> playerStats;
    private MatchType matchType;
    private String mapName;
}
