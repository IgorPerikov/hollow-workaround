package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.mapping.Mapper;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByMatchId;

@Data
public class PlayerStatsByMatchIdRepository {

    private final Mapper<PlayerStatsByMatchId> mapper;
}
