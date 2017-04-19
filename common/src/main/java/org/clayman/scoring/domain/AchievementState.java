package org.clayman.scoring.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class AchievementState {
    private UUID achievementId;
    private UUID playerId;
    private Integer playerValue;
    private Integer obtainedLevel;
}
