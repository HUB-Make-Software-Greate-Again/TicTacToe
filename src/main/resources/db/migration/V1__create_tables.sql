CREATE TABLE EndStates(
    ID SERIAL,
    outcome VARCHAR NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Results(
    ID SERIAL,
    SID INT,
    created TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY (SID) REFERENCES EndStates(id)
);