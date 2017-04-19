package org.clayman.scoring.domain.match;

import lombok.Data;

@Data
public class AssaultPlayerStats extends PlayerStats {
    private Integer stagesTaken;
    private Integer stagesDefended;
}
