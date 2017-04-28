package org.clayman.scoring.input.service;

import org.clayman.scoring.common.domain.MatchInfo;
import org.clayman.scoring.input.repository.MatchInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class MatchInfoService {

    @Autowired
    private MatchInfoRepository matchInfoRepository;

    public void save(MatchInfo matchInfo) {
        matchInfo.setTime(ZonedDateTime.now());
        matchInfoRepository.save(matchInfo);
    }
}
