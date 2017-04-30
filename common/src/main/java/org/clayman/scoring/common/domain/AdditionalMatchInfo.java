package org.clayman.scoring.common.domain;

import lombok.Data;

import java.time.Duration;

@Data
public class AdditionalMatchInfo {
    private MatchType matchType;
    private String mapName;
}
