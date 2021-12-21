CREATE TABLE license_plate
(
    licenseId   serial PRIMARY KEY NOT NULL,
    numberPlate varchar(10)        NOT NULL,
    countryCode varchar(2)         NOT NULL
);

CREATE TABLE membership
(
    membershipId        serial PRIMARY KEY                       NOT NULL,
    registrationDate    DATE                                     NOT NULL,
    fk_license_plate_id INT REFERENCES license_plate (licenseId) NOT NULL
);

ALTER TABLE person
    ADD COLUMN fk_membership_id int REFERENCES membership (memberId);

ALTER TABLE person
    ADD COLUMN role VARCHAR(10);