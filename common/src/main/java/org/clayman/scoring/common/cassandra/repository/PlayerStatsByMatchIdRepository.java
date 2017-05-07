package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByMatchId;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlayerStatsByMatchIdRepository {

    private final Session session;
    private final Mapper<PlayerStatsByMatchId> mapper;

    public void save(PlayerStatsByMatchId entity) {
        mapper.save(entity);
    }

    public List<PlayerStatsByMatchId> find(UUID matchId) {
        TableMetadata tableMetadata = mapper.getTableMetadata();

        Statement query = QueryBuilder.select()
                .from(tableMetadata)
                .where(QueryBuilder.eq("match_id", matchId));

        ResultSet resultSet = session.execute(query);
        return mapper.map(resultSet).all();
    }
}
