package org.clayman.scoring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Achievement {
    private UUID id;
    private AchievementCondition achievementCondition;
    private Map<Integer, Integer> achievementLevelToRequiredResultMap;
}
