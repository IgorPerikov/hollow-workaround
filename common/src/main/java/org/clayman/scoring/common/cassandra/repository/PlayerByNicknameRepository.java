package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.TableMetadata;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerByNickname;

import java.util.List;

@AllArgsConstructor
public class PlayerByNicknameRepository {

    private final Session session;
    private final Mapper<PlayerByNickname> mapper;

    public List<PlayerByNickname> getPlayersWithGivenNickname(String nickname) {
        TableMetadata tableMetadata = mapper.getTableMetadata();

        Statement query = QueryBuilder.select()
                .from(tableMetadata)
                .where(QueryBuilder.eq("nickname", nickname));

        ResultSet resultSet = session.execute(query);
        return mapper.map(resultSet).all();
    }
}
