CREATE TABLE players_stats_by_match_id (
    match_id uuid,
    player_id uuid,
    rating_points int,
    kills int,
    deaths int,
    start_time timestamp,
    additional_info frozen <additional_match_info>,
    PRIMARY KEY (match_id, player_id));
