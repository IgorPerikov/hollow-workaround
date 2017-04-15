package org.clayman.scoring.domain.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CTFPlayerStats extends PlayerStats {
    private Integer flagBringerKills;
    private Integer flagsReturnedHome;
    private Integer flagsCaptured;
}
