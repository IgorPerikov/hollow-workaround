CREATE TABLE online_scoring.intermediate_rating_by_player_id (
    player_id uuid,
    update_time timestamp,
    rating int,
    PRIMARY KEY(player_id, update_time));
