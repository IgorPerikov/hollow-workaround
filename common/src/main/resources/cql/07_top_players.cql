CREATE MATERIALIZED VIEW online_scoring.top_players 
    AS SELECT *
    FROM online_scoring.player_profile_by_player_id
    WHERE player_id IS NOT NULL AND rating_points IS NOT NULL AND stub IS NOT NULL
    PRIMARY KEY(stub, rating_points, player_id)
    WITH CLUSTERING ORDER BY (rating_points DESC);
