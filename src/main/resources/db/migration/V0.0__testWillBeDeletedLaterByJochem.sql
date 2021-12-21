create table testWillBeDeletedJustIgnore(
    id serial primary key,
    test varchar(50)
);

insert into testWillBeDeletedJustIgnore(test)
VALUES ('this is just to make it work');