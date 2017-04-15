package org.clayman.scoring.domain.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PlayerStats {
    private Integer kills;

    private Integer killsWithEnforcer;
    private Integer killsWithBioRifle;
    private Integer killsWithShockRifle;
    private Integer killsWithPulseGun;
    private Integer killsWithFlakCannon;
    private Integer killsWithRocketLauncher;
    private Integer killsWithSniperRifle;
    private Integer killsWithRedeemer;

    private Integer deaths;
    private Integer damadeDealt;
    private Integer damageAcquired;

    private boolean firstBlood;
    private boolean firstDeathInMatch;

    private Integer headshots;

    private Integer killingSprees; // 5
    private Integer rampages; // 10
    private Integer dominatings; // 15
    private Integer unstoppables; // 20
    private Integer godlikes; // 25
    private Integer wickedSicks; // 30

    private Integer doubleKills; // 2
    private Integer multiKills; // 3
    private Integer megaKills; // 4
    private Integer ultraKills; // 5
    private Integer monsterKills; // 6
    private Integer ludicrousKills; // 7
    private Integer holyShits; // 8+
}
