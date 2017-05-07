package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.TableMetadata;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByPlayerId;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class PlayerStatsByPlayerIdRepository {

    private final Session session;
    private final Mapper<PlayerStatsByPlayerId> mapper;

    public List<PlayerStatsByPlayerId> find(UUID playerId) {
        TableMetadata tableMetadata = mapper.getTableMetadata();

        Statement query = QueryBuilder.select()
                .from(tableMetadata)
                .where(QueryBuilder.eq("player_id", playerId));

        ResultSet resultSet = session.execute(query);
        return mapper.map(resultSet).all();
    }
}
