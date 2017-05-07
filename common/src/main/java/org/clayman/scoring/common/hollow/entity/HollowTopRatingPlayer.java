package org.clayman.scoring.common.hollow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HollowTopRatingPlayer {
    UUID playerId;
    Integer ratingPoints;
    String nickname;
}
