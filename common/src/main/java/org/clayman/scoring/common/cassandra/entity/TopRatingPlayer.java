package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Table(keyspace = "online_scoring", name = "top_players")
public class TopRatingPlayer {

    @PartitionKey(0)
    @Column(name = "stub")
    private Integer stub;

    @ClusteringColumn(0)
    @Column(name = "rating_points")
    private Integer ratingPoints;

    @ClusteringColumn(1)
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "nickname")
    private String nickname;
}
