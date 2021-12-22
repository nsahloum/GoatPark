create sequence license_plate_seq start with 1 increment by 1;
CREATE TABLE license_plate
(
    ID           int         NOT NULL default nextval('license_plate_seq') PRIMARY KEY,
    number_plate varchar(10) NOT NULL,
    country_code varchar(2)  NOT NULL
);
create sequence membership_seq start with 1 increment by 1;
CREATE TABLE membership
(
    ID                  int  NOT NULL default nextval('membership_seq') PRIMARY KEY,
    registration_date   DATE NOT NULL,
    fk_license_plate_id INT  NOT NULL,
    CONSTRAINT fk_membership_license_plate_id foreign key (fk_license_plate_id) REFERENCES license_plate (id)
);

ALTER TABLE person
    ADD COLUMN fk_membership_id int;

ALTER TABLE person
    ADD CONSTRAINT fk_person_membership_id foreign key (fk_membership_id) REFERENCES membership (id);