package org.clayman.scoring.input.controller;

import org.clayman.scoring.input.domain.MatchResult;
import org.clayman.scoring.input.service.MatchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchResultInputController {

    @Autowired
    private MatchResultService matchResultService;

    @PostMapping("/match-result")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchResult postNewMatchResult(@RequestBody @Validated MatchResult matchResult) {
        return matchResultService.saveMatchResult(matchResult);
    }
}
