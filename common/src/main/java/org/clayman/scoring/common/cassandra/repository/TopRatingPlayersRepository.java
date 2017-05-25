package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.TableMetadata;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;
import org.clayman.scoring.common.cassandra.entity.TopRatingPlayer;

import java.util.List;

@AllArgsConstructor
public class TopRatingPlayersRepository {

    private static final Integer TOP_PLAYERS_LIMIT = 100;

    private final Session session;
    private final Mapper<TopRatingPlayer> mapper;

    public List<TopRatingPlayer> getTopPlayers() {
        TableMetadata metadata = mapper.getTableMetadata();

        Statement statement = QueryBuilder.select()
                .from("online_scoring", "top_players")
                .where(QueryBuilder.eq("stub", PlayerProfileByPlayerId.STUB_VALUE))
                .limit(TOP_PLAYERS_LIMIT);

        ResultSet resultSet = session.execute(statement);
        return mapper.map(resultSet).all();
    }
}
