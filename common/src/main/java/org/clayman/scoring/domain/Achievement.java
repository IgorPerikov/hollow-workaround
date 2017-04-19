package org.clayman.scoring.domain;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class Achievement {
    private UUID id;
    private AchievementCondition achievementCondition;
    private Map<Integer, Integer> achievementLevelToRequiredResultMap;
}
