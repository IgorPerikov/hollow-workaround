package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import lombok.AllArgsConstructor;
import org.clayman.scoring.common.cassandra.entity.HollowStateAnnouncement;

@AllArgsConstructor
public class HollowStateAnnouncementRepository {

    private static final Integer FAKE_ID_VALUE = 0;

    private final Session session;
    private final Mapper<HollowStateAnnouncement> mapper;

    public void announceNewState(Long stateVersion) {
        mapper.save(new HollowStateAnnouncement(FAKE_ID_VALUE, stateVersion));
    }

    public Long getLastState() {
        Statement query = QueryBuilder.select()
                .from(mapper.getTableMetadata())
                .where(QueryBuilder.eq("fake_id", FAKE_ID_VALUE));

        ResultSet resultSet = session.execute(query);
        return mapper.map(resultSet).one().getStateVersion();
    }
}
