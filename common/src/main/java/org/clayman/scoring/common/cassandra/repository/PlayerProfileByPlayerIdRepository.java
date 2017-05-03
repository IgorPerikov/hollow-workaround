package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.mapping.Mapper;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;

@Data
public class PlayerProfileByPlayerIdRepository {

    private final Mapper<PlayerProfileByPlayerId> mapper;
}
