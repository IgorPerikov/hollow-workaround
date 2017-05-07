package org.clayman.scoring.common.dto.output;

import lombok.Data;

import java.util.UUID;

@Data
public class PlayerProfile {
    private Integer ratingPoints;
    private UUID playerId;
    private String nickname;
}
