package org.clayman.scoring.domain;

import java.util.Map;
import java.util.UUID;

public class Achievement {

    private UUID id;
    private AchievementCondition achievementCondition;
    private Map<Integer, Integer> achievementLevelToRequiredResultMap;
}
