package org.clayman.scoring.input.configuration;

import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.*;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.extras.codecs.jdk8.InstantCodec;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.clayman.scoring.common.MatchType;
import org.clayman.scoring.common.cassandra.entity.PlayerProfileByPlayerId;
import org.clayman.scoring.common.cassandra.entity.PlayerStatsByMatchId;
import org.clayman.scoring.common.cassandra.repository.PlayerProfileByPlayerIdRepository;
import org.clayman.scoring.common.cassandra.repository.PlayerStatsByMatchIdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfiguration {

    @Bean(destroyMethod = "close")
    public Cluster cluster() {
        CodecRegistry codecRegistry = new CodecRegistry();
        codecRegistry.register(InstantCodec.instance);
        codecRegistry.register(new EnumNameCodec<>(MatchType.class));

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setConsistencyLevel(ConsistencyLevel.QUORUM);

        Cluster.Builder builder = Cluster.builder()
                .addContactPoint("localhost")
                .withCodecRegistry(codecRegistry)
                .withCompression(ProtocolOptions.Compression.LZ4)
                .withQueryOptions(queryOptions)
                .withRetryPolicy(DowngradingConsistencyRetryPolicy.INSTANCE); // TODO

        return builder.build();
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
    public PlayerProfileByPlayerIdRepository playerProfileByPlayerIdRepository(
            Session session,
            MappingManager mappingManager
    ) {
        Mapper<PlayerProfileByPlayerId> mapper = mappingManager.mapper(PlayerProfileByPlayerId.class);
        return new PlayerProfileByPlayerIdRepository(session, mapper);
    }

    @Bean
    public PlayerStatsByMatchIdRepository playerStatsByMatchIdRepository(
            Session session,
            MappingManager mappingManager
    ) {
        Mapper<PlayerStatsByMatchId> mapper = mappingManager.mapper(PlayerStatsByMatchId.class);
        return new PlayerStatsByMatchIdRepository(session, mapper);
    }
}
