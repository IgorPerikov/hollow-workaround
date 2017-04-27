package org.clayman.scoring.common.domain;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class CTFPlayerStats extends PlayerStats {
    private Integer flagBringerKills;
    private Integer flagsReturnedHome;
    private Integer flagsCaptured;
}
