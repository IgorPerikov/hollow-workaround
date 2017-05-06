package org.clayman.scoring.input.controller;

import org.clayman.scoring.common.dto.input.Player;
import org.clayman.scoring.input.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    public ResponseEntity<Player> registerNewPlayer(@RequestBody Player player) {
        Player registeredPlayer = playerService.registerNewPlayer(player);
        return new ResponseEntity<>(registeredPlayer, HttpStatus.CREATED);
    }
}
