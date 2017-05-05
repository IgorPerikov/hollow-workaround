package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Table(keyspace = "online_scoring", name = "player_profile_by_player_id")
public class PlayerProfileByPlayerId {

    private static final Integer STUB_VALUE = 0;

    @PartitionKey
    @Column(name = "player_id")
    private UUID playerId;

    /**
     * only needed for support top_players materialized view
     */
    @ClusteringColumn
    @Column(name = "stub")
    private Integer stub = STUB_VALUE;

    @Column(name = "rating_points")
    private Integer ratingPoints;

    @Column(name = "nickname")
    private String nickname;
}
