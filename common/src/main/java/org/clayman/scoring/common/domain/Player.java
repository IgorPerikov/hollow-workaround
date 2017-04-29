package org.clayman.scoring.common.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {
    private UUID id;
    private String nickname;
    private Region region;
}
