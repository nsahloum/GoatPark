create sequence division_seq start with 1 increment by 1;
CREATE TABLE divisions
(
    ID            int                NOT NULL default nextval('division_seq') PRIMARY KEY,
    NAME          VARCHAR(60) UNIQUE not null,
    original_name VARCHAR(40) UNIQUE not null,
    director      varchar(60)        not null
)
