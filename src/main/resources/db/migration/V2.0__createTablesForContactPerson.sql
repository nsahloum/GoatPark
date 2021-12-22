create sequence POSTAL_CODE_seq start with 1 increment by 1;
CREATE TABLE POSTAL_CODE
(
    ID    int         NOT NULL default nextval('POSTAL_CODE_seq') PRIMARY KEY,
    CODE  VARCHAR(4)  NOT NULL,
    LABEL VARCHAR(85) NOT NULL
);
create sequence ADDRESS_seq start with 1 increment by 1;
CREATE TABLE ADDRESS
(
    ID             int         NOT NULL default nextval('ADDRESS_seq') PRIMARY KEY,
    STREET_NAME    VARCHAR(32) NOT NULL,
    STREET_NUMBER  VARCHAR(10) NOT NULL,
    FK_POSTAL_CODE integer     NOT NULL,
    CONSTRAINT FK_ADDRESS_POSTAL_CODE foreign key (FK_POSTAL_CODE) references POSTAL_CODE (ID)
);
create sequence EMAIL_ADDRESS_seq start with 1 increment by 1;
CREATE TABLE EMAIL_ADDRESS
(
    ID       int         NOT NULL default nextval('EMAIL_ADDRESS_seq') PRIMARY KEY,
    USERNAME VARCHAR(64) NOT NULL,
    DOMAIN   VARCHAR(64) NOT NULL
);
create sequence PHONE_NUMBER_seq start with 1 increment by 1;
CREATE TABLE PHONE_NUMBER
(
    ID     int         NOT NULL default nextval('PHONE_NUMBER_seq') PRIMARY KEY,
    PREFIX VARCHAR(4)  NOT NULL,
    NUMBER VARCHAR(20) NOT NULL
);
create sequence PERSON_seq start with 1 increment by 1;
CREATE TABLE PERSON
(
    ID               int         NOT NULL default nextval('PERSON_seq') PRIMARY KEY,
    NAME             VARCHAR(64) NOT NULL,
    FK_PHONE_NUMBER  integer,
    FK_MOBILE_NUMBER integer,
    FK_EMAIL_ADDRESS integer     NOT NULL,
    FK_ADDRESS       integer     NOT NULL,
    role             VARCHAR(20),
    CONSTRAINT FK_PERSON_PHONE_NUMBER foreign key (FK_PHONE_NUMBER) references PHONE_NUMBER (ID),
    CONSTRAINT FK_PERSON_MOBILE_NUMBER foreign key (FK_MOBILE_NUMBER) references PHONE_NUMBER (ID),
    CONSTRAINT FK_PERSON_EMAIL_ADDRESS foreign key (FK_EMAIL_ADDRESS) references EMAIL_ADDRESS (ID),
    CONSTRAINT FK_PERSON_ADDRESS foreign key (FK_ADDRESS) references ADDRESS (ID)
);