CREATE TABLE divisions
(
    ID            SERIAL PRIMARY KEY NOT NULL,
    NAME          VARCHAR(60) UNIQUE not null,
    original_name VARCHAR(40) UNIQUE not null,
    director      varchar(60)        not null
)