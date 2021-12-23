create sequence parking_spot_allocation_seq start with 1 increment by 1;
CREATE TABLE PARKING_SPOT_ALLOCATION
(
    ID                int NOT NULL default nextval('parking_spot_allocation_seq') PRIMARY KEY,
    FK_PERSON_ID      int not null,
    FK_PARKING_LOT_ID int not null,
    CONSTRAINT fk_person_id foreign key (FK_PERSON_ID) references person (id),
    CONSTRAINT fk_parking_lot_id foreign key (FK_PARKING_LOT_ID) references parking_lot (id)

)