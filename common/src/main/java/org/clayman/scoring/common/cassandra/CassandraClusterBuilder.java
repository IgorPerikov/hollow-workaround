package org.clayman.scoring.common.cassandra;

import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.DowngradingConsistencyRetryPolicy;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.extras.codecs.jdk8.InstantCodec;
import org.clayman.scoring.common.MatchType;

public class CassandraClusterBuilder {

    public static Cluster buildCluster() {
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
}
