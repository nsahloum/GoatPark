CREATE TABLE license_plate
(
    id           serial PRIMARY KEY NOT NULL,
    number_plate varchar(10)        NOT NULL,
    country_code varchar(2)         NOT NULL
);

CREATE TABLE membership
(
    id                  serial PRIMARY KEY NOT NULL,
    registration_date   DATE               NOT NULL,
    fk_license_plate_id INT                NOT NULL,
    CONSTRAINT fk_membership_license_plate_id foreign key (fk_license_plate_id) REFERENCES license_plate (id)
);

ALTER TABLE person
    ADD COLUMN fk_membership_id int,
    ADD CONSTRAINT fk_person_membership_id foreign key (fk_membership_id) REFERENCES membership(id);