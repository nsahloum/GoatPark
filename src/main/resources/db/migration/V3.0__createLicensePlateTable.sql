CREATE TABLE license_plate
(
    id           serial PRIMARY KEY NOT NULL,
    number_plate varchar(10)        NOT NULL,
    country_code varchar(2)         NOT NULL
);

CREATE TABLE membership
(
    id                  serial PRIMARY KEY                NOT NULL,
    registration_date   DATE                              NOT NULL,
    fk_license_plate_id INT REFERENCES license_plate (id) NOT NULL
);

ALTER TABLE person
    ADD COLUMN fk_membership_id int REFERENCES membership (id);

ALTER TABLE person
    ADD COLUMN role VARCHAR(20);