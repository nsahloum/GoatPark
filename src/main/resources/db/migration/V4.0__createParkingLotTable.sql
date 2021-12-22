CREATE TABLE parking_lot
(
    id       SERIAL PRIMARY KEY NOT NULL,
    name     varchar(60) not null,
    category varchar(40) not null,
    maximum_capacity integer not null,
    fk_person_id integer not null,
    fk_address_id integer not null,
    price_per_hour float not null,
    CONSTRAINT fk_parking_lot_person_id foreign key (fk_person_id) references PERSON (id),
    CONSTRAINT fk_parking_lot_address_id foreign key (fk_address_id) references ADDRESS (id)
)
