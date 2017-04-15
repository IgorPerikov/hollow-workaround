package org.clayman.scoring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Player {
    private UUID id;
    private String nickname;
}
