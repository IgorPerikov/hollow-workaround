package org.clayman.scoring.domain.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssaultPlayerStats extends PlayerStats {
    private Integer stagesTaken;
    private Integer stagesDefended;
}
