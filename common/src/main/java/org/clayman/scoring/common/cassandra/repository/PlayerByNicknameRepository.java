package org.clayman.scoring.common.cassandra.repository;

import com.datastax.driver.mapping.Mapper;
import lombok.Data;
import org.clayman.scoring.common.cassandra.entity.PlayerByNickname;

@Data
public class PlayerByNicknameRepository {

    private final Mapper<PlayerByNickname> mapper;
}
