package org.clayman.scoring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AchievementState {
    private UUID achievementId;
    private UUID playerId;
    private Integer playerValue;
    private Integer obtainedLevel;
}
