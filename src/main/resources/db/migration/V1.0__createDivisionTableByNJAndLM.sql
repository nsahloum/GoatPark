CREATE TABLE divisions
(
    ID            SERIAL PRIMARY KEY NOT NULL,
    NAME          VARCHAR(60)        not null,
    original_name VARCHAR(40)        not null,
    director      varchar(60)        not null
);