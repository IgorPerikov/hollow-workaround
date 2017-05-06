package org.clayman.scoring.input.controller;

import org.clayman.scoring.common.cassandra.entity.AdditionalMatchInfoUDT;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByMatchId;
import org.clayman.scoring.common.dto.input.MatchResult;
import org.clayman.scoring.input.service.MatchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class MatchResultController {

    @Autowired
    private MatchResultService matchResultService;

    @PostMapping("/results")
    public ResponseEntity<Void> saveMatchResult(@RequestBody @Validated MatchResult matchResult) {
        matchResult.setMatchId(UUID.randomUUID());
        matchResultService.save(convertMatchResult(matchResult));
        return ResponseEntity.noContent().build();
    }

    private List<PlayerStatsByMatchId> convertMatchResult(MatchResult matchResult) {
        return matchResult.getPlayersStats()
                .stream()
                .map(playerStats -> {
                    return new PlayerStatsByMatchId(
                            matchResult.getMatchId(),
                            playerStats.getPlayerId(),
                            playerStats.getRatingPoints(),
                            playerStats.getKills(),
                            playerStats.getDeaths(),
                            Instant.now(),
                            new AdditionalMatchInfoUDT(matchResult.getMatchType(), matchResult.getMapName())
                    );
                }).collect(Collectors.toList());
    }
}
