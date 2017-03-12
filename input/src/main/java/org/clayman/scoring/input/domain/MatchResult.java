package org.clayman.scoring.input.domain;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class MatchResult {

    @NotNull
    private UUID uuid;

    @NotNull
    private Instant startTime;

    @NotNull
    private Instant endTime;

    @NotNull
    private Map<String, Integer> playersScores;

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
