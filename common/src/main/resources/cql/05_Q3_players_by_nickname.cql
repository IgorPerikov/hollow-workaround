CREATE TABLE player_ids_by_nickname (
    nickname text,
    player_id uuid,
    PRIMARY KEY (nickname, player_id));
