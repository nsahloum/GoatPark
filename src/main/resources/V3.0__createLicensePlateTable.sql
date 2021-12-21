CREATE TABLE license_plate
(
    licenseId    serial PRIMARY KEY         NOT NULL,
    numberPlate  varchar(10)                NOT NULL,
    countryCode  varchar(2)                 NOT NULL,
    fk_person_id int REFERENCES person (id) NOT NULL
);

CREATE TABLE membership
(
    membershipId     serial PRIMARY KEY NOT NULL,
    registrationDate DATE               NOT NULL
);

ALTER TABLE person
    ADD COLUMN fk_membership_id int REFERENCES membership (memberId);

-- ALTER TABLE person
-- ADD COLUMN  roleId