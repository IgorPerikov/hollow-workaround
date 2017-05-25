package org.clayman.scoring.output.controller;

import org.clayman.scoring.common.dto.output.PlayerProfile;
import org.clayman.scoring.output.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/top-players")
    public List<PlayerProfile> getTopPlayers() {
        return playerService.getTopPlayers();
    }

    @GetMapping("/players/{id}")
    public PlayerProfile getPlayerById(@PathVariable UUID id) {
        return playerService.getPlayerById(id);
    }
}
