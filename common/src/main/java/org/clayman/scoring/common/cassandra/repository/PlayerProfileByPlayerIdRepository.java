package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.TableMetadata;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;

import java.util.UUID;

@AllArgsConstructor
public class PlayerProfileByPlayerIdRepository {

    private final Session session;
    private final Mapper<PlayerProfileByPlayerId> mapper;

    public void save(PlayerProfileByPlayerId entity) {
        mapper.save(entity);
    }

    public PlayerProfileByPlayerId find(UUID playerId) {
        TableMetadata tableMetadata = mapper.getTableMetadata();

        Statement query = QueryBuilder.select()
                .from(tableMetadata)
                .where(QueryBuilder.eq("player_id", playerId));

        ResultSet resultSet = session.execute(query);
        return mapper.map(resultSet).one();
    }
}
