package org.clayman.scoring.common.cassandra.entity;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clayman.scoring.common.MatchType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UDT(keyspace = "online_scoring", name = "additional_match_info")
public class AdditionalMatchInfoUDT {

    @Field(name = "match_type")
    private MatchType matchType;

    @Field(name = "map_name")
    private String mapName;
}
