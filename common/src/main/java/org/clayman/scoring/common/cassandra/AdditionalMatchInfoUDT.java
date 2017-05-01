package org.clayman.scoring.common.cassandra;

import lombok.Data;
import org.clayman.scoring.common.MatchType;

@Data
public class AdditionalMatchInfoUDT {
    private MatchType matchType;
    private String mapName;
}
