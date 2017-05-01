package org.clayman.scoring.common.cassandra;

import lombok.Data;

import java.util.UUID;

@Data
public class PlayerByNickname {
    private String nickname;
    private UUID playerId;
}
