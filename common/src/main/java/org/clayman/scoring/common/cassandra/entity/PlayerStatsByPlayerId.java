package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Table(keyspace = "online_scoring", name = "players_stats_by_player_id")
public class PlayerStatsByPlayerId {

    @PartitionKey
    @Column(name = "player_id")
    private UUID playerId;

    @ClusteringColumn
    @Column(name = "start_time")
    private Instant startTime;

    @ClusteringColumn
    @Column(name = "match_id")
    private UUID matchId;

    @Column(name = "rating_points")
    private Integer ratingPoints;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    @Frozen // TODO: figure out should I place it?
    @Field(name = "additional_info")
    private AdditionalMatchInfoUDT additionalInfo;
}
