package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;
import org.clayman.scoring.common.MatchType;

@Data
@UDT(keyspace = "online_scoring", name = "additional_match_info")
public class AdditionalMatchInfoUDT {

    @Column(name = "match_type")
    private MatchType matchType;

    @Column(name = "map_name")
    private String mapName;
}
