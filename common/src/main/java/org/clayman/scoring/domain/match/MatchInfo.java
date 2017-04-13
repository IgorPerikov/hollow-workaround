package org.clayman.scoring.domain.match;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

public class MatchInfo {

    private UUID id;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Map<UUID, PlayerStats> playerStats;
    private MatchType matchType;
    private String mapName;
}
