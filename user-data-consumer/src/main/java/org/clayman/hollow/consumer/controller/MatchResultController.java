package org.clayman.hollow.consumer.controller;

import org.clayman.hollow.common.data.MatchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchResultController {

    @PostMapping
    public ResponseEntity postMatchResult(@RequestBody MatchResult matchResult) {

    }
}
