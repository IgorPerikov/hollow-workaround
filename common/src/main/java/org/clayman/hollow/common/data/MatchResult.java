package org.clayman.hollow.common.data;

import java.time.Instant;
import java.util.Map;

public class MatchResult {

    private final Map<Player, Integer> playersScore;
    private final Instant matchStartTime;
    private final Instant matchEndTime;

    public MatchResult(Map<Player, Integer> playersScore, Instant matchStartTime, Instant matchEndTime) {
        this.playersScore = playersScore;
        this.matchStartTime = matchStartTime;
        this.matchEndTime = matchEndTime;
    }

    public Map<Player, Integer> getPlayersScore() {
        return playersScore;
    }

    public Instant getMatchStartTime() {
        return matchStartTime;
    }

    public Instant getMatchEndTime() {
        return matchEndTime;
    }
}
