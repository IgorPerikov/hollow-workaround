package org.clayman.scoring.input.controller;

import org.clayman.scoring.common.cassandra.MatchInfoByPlayerId;
import org.clayman.scoring.input.service.MatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchResultController {

    @Autowired
    private MatchInfoService matchInfoService;

    @PostMapping("/match-result")
    public ResponseEntity saveResult(@RequestBody MatchInfoByPlayerId matchInfoByPlayerId) {
        matchInfoService.save(matchInfoByPlayerId);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
