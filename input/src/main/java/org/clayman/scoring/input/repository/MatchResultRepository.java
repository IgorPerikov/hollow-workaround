package org.clayman.scoring.input.repository;

import com.datastax.driver.core.Session;
import org.clayman.scoring.input.domain.MatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchResultRepository {

    @Autowired
    private Session session;

    public void saveMatchResult(MatchResult matchResult) {

    }
}
