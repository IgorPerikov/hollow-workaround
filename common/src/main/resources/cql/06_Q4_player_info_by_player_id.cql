CREATE TABLE online_scoring.player_info_by_player_id (
    player_id uuid,
    rating_points int,
    rating_last_update_time timestamp,
    nickname text,
    stub int,
    PRIMARY KEY(player_id, rating_points));
