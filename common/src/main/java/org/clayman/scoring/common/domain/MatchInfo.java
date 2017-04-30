package org.clayman.scoring.common.domain;

import lombok.Data;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Data
public class MatchInfo {
    private UUID matchId;
    private Instant startTime;
    private AdditionalMatchInfo additionalMatchInfo;
}
