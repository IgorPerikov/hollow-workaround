CREATE TABLE player_info_by_player_id (
    player_id uuid,
    rating_points int,
    nickname text,
    PRIMARY KEY((player_id), rating_points))
WITH CLUSTERING ORDER BY (rating_points DESC);
