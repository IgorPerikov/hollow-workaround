CREATE TABLE online_scoring.player_profile_by_player_id (
    player_id uuid,
    rating_points int,
    nickname text,
    stub int,
    PRIMARY KEY(player_id, stub));
