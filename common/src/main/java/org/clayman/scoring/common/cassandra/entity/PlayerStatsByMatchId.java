package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(keyspace = "online_scoring", name = "players_stats_by_match_id")
public class PlayerStatsByMatchId {

    @PartitionKey
    @Column(name = "match_id")
    private UUID matchId;

    @ClusteringColumn
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "rating_points_gained")
    private Integer ratingPointsGained;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "start_time")
    private Instant startTime;

    @Frozen // TODO: figure out should I place it?
    @Column(name = "additional_info")
    private AdditionalMatchInfoUDT additionalInfo;
}
