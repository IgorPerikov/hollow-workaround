package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.mapping.Mapper;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByPlayerId;

@Data
public class PlayerStatsByPlayerIdRepository {

    private final Mapper<PlayerStatsByPlayerId> mapper;
}
