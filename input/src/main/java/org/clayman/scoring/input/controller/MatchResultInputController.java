package org.clayman.scoring.input.controller;

import org.clayman.scoring.input.domain.MatchResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchResultInputController {

    @PostMapping("/match-result")
    public void postNewMatchResult(@RequestBody @Validated MatchResult matchResult) {

    }
}
