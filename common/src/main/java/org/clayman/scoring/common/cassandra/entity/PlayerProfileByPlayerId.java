package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Table(keyspace = "online_scoring", name = "player_profile_by_player_id")
public class PlayerProfileByPlayerId {

    @PartitionKey
    @Column(name = "player_id")
    private UUID playerId;

    @ClusteringColumn
    @Column(name = "rating_points")
    private Integer ratingPoints;

    @Column(name = "rating_last_update_time")
    private Instant ratingLastUpdateTime;

    @Column(name = "nickname")
    private String nickname;

    /**
     * only needed for support top_players materialized view
     */
    @Column(name = "stub")
    private final Integer stub = 0;
}
