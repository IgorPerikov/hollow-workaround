package org.clayman.scoring.common.domain;

import lombok.Data;

@Data
public abstract class PlayerStats {
    private Integer kills;
    private Integer deaths;
    private Integer longestSpree;
}
