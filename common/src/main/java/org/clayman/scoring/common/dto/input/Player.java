package org.clayman.scoring.common.dto.input;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {

    private UUID playerId;
    private String nickname;
}
