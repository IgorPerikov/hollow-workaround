package org.clayman.scoring.domain.match;

import lombok.Data;

@Data
public class CTFPlayerStats extends PlayerStats {
    private Integer flagBringerKills;
    private Integer flagsReturnedHome;
    private Integer flagsCaptured;
}
