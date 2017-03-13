package org.clayman.scoring.input.service;

import org.clayman.scoring.input.domain.MatchResult;
import org.clayman.scoring.input.repository.MatchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MatchResultService {

    @Autowired
    private MatchResultRepository matchResultRepository;

    public MatchResult saveMatchResult(MatchResult matchResult) {
        matchResult.setUuid(UUID.randomUUID());
        matchResultRepository.saveMatchResult(matchResult);
        return matchResult;
    }
}
