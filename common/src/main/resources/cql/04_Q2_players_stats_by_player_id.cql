CREATE MATERIALIZED VIEW online_scoring.players_stats_by_player_id
    AS SELECT *
    FROM online_scoring.players_stats_by_match_id
    WHERE match_id IS NOT NULL AND player_id IS NOT NULL AND start_time IS NOT NULL
    PRIMARY KEY (player_id, start_time, match_id)
    WITH CLUSTERING ORDER BY (start_time DESC);
