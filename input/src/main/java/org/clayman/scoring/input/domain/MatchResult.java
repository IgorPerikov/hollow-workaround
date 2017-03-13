package org.clayman.scoring.input.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class MatchResult {

    @Null
    private UUID uuid;

    @NotNull
    private Instant startTime;

    @NotNull
    private Instant endTime;

    @NotNull
    private Map<String, Integer> playersScores;

    public MatchResult setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public Map<String, Integer> getPlayersScores() {
        return playersScores;
    }
}
