package org.clayman.hollow.producer.controller;

import org.clayman.hollow.common.data.MatchResult;
import org.clayman.hollow.producer.service.MatchResultHollowConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MatchResultOutputController {

    @Autowired
    private MatchResultHollowConsumer hollowConsumer;

    @GetMapping("/match/{matchId}")
    public MatchResult getMatchResult(@PathVariable UUID matchId) {

    }
}
