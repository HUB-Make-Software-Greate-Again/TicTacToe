ALTER TABLE endstates ALTER COLUMN id DROP DEFAULT;
ALTER SEQUENCE endstates_id_seq OWNED BY NONE;
DROP SEQUENCE endstates_id_seq;

INSERT INTO endstates(ID, outcome)
VALUES(0, 'Draw'), (1, 'Player one wins'), (2, 'Player two wins');