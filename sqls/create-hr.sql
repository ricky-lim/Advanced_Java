CREATE TABLE IF NOT EXISTS People (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL
);

INSERT OR REPLACE INTO People (name) values("Picard");
INSERT OR REPLACE INTO People (name) values("Riker");
INSERT OR REPLACE INTO People (name) values("Troi");
INSERT OR REPLACE INTO People (name) values("Laforge");
INSERT OR REPLACE INTO People (name) values("Data");
INSERT OR REPLACE INTO People (name) values("Crusher");