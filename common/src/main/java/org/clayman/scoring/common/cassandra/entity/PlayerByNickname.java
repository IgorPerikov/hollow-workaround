package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Table(keyspace = "online_scoring", name = "player_ids_by_nickname")
public class PlayerByNickname {

    @PartitionKey
    @Column(name = "nickname")
    private String nickname;

    @ClusteringColumn
    @Column(name = "player_id")
    private UUID playerId;
}
