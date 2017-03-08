package org.clayman.hollow.common.data;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class MatchResult {

    private final UUID uuid;
    private final Map<Player, Integer> playersScore;
    private final Instant matchEndTime;

    public MatchResult(UUID uuid, Map<Player, Integer> playersScore, Instant matchEndTime) {
        this.uuid = uuid;
        this.playersScore = playersScore;
        this.matchEndTime = matchEndTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Map<Player, Integer> getPlayersScore() {
        return playersScore;
    }

    public Instant getMatchEndTime() {
        return matchEndTime;
    }
}
