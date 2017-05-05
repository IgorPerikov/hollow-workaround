CREATE MATERIALIZED VIEW online_scoring.players_by_nickname
    AS SELECT nickname, player_id, rating_points
    FROM online_scoring.player_profile_by_player_id
    WHERE player_id IS NOT NULL AND nickname IS NOT NULL AND stub IS NOT NULL
    PRIMARY KEY(nickname, player_id, stub);
