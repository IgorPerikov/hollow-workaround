package org.clayman.scoring.common.dto.input;

import lombok.Data;
import org.clayman.scoring.common.MatchType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class MatchResult {

    private UUID matchId;
    private Instant startTime;
    private MatchType matchType;
    private String mapName;

    private List<PlayerStats> playersStats;

    @Data
    static class PlayerStats {
        private UUID playerId;
        private Integer ratingPoints;
        private Integer kills;
        private Integer deaths;
    }
}
