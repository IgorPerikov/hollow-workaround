package org.clayman.hollow.consumer.controller;

import org.clayman.hollow.common.data.MatchResult;
import org.clayman.hollow.consumer.service.MatchResultHollowProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MatchResultInputController {

    @Autowired
    private MatchResultHollowProducer hollowProducer;

    @PostMapping("/match")
    public MatchResult postMatchResult(@RequestBody MatchResult matchResult) {
        matchResult.setUuid(UUID.randomUUID());
        hollowProducer.store(matchResult);
        return matchResult;
    }
}
