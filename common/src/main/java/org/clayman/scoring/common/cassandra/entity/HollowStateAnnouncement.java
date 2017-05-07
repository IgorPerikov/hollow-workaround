package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(keyspace = "online_scoring", name = "hollow_state_announcements")
public class HollowStateAnnouncement {

    @PartitionKey
    @Column(name = "fake_id")
    private Integer fakeId;

    @Column(name = "state_version")
    private Long stateVersion;
}
