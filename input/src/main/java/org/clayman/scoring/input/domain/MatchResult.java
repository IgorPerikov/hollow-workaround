package org.clayman.scoring.input.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Table(name = "match_results")
public class MatchResult {

    @Null
    @Column(name = "uuid")
    private UUID uuid;

    @NotNull
    @Column(name = "start_time")
    private Instant startTime;

    @NotNull
    @Column(name = "end_time")
    private Instant endTime;

    @NotNull
    @Column(name = "players_scores")
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
