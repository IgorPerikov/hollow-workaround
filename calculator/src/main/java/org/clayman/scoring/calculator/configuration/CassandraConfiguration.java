package org.clayman.scoring.calculator.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.clayman.scoring.common.cassandra.CassandraClusterBuilder;
import org.clayman.scoring.common.cassandra.entity.HollowStateAnnouncement;
import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;
import org.clayman.scoring.common.cassandra.entity.TopRatingPlayer;
import org.clayman.scoring.common.cassandra.repository.HollowStateAnnouncementRepository;
import org.clayman.scoring.common.cassandra.repository.PlayerProfileByPlayerIdRepository;
import org.clayman.scoring.common.cassandra.repository.TopRatingPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfiguration {

    @Bean(destroyMethod = "close")
    public Cluster cluster() {
        return CassandraClusterBuilder.buildCluster();
    }

    @Bean(destroyMethod = "close")
    public Session session(Cluster cluster) {
        return cluster.newSession();
    }

    @Bean
    public MappingManager mappingManager(Session session) {
        return new MappingManager(session);
    }

    @Bean
    public TopRatingPlayersRepository topRatingPlayersRepository(Session session, MappingManager mappingManager) {
        Mapper<TopRatingPlayer> mapper = mappingManager.mapper(TopRatingPlayer.class);
        return new TopRatingPlayersRepository(session, mapper);
    }

    @Bean
    public HollowStateAnnouncementRepository hollowStateAnnouncementRepository(
            Session session,
            MappingManager mappingManager
    ) {
        Mapper<HollowStateAnnouncement> mapper = mappingManager.mapper(HollowStateAnnouncement.class);
        return new HollowStateAnnouncementRepository(session, mapper);
    }

    @Bean
    public PlayerProfileByPlayerIdRepository playerProfileByPlayerIdRepository(
            Session session,
            MappingManager mappingManager
    ) {
        Mapper<PlayerProfileByPlayerId> mapper = mappingManager.mapper(PlayerProfileByPlayerId.class);
        return new PlayerProfileByPlayerIdRepository(session, mapper);
    }
}
