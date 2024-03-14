create table tests
(
    id          bigint default nextval('tests_id_seq'::regclass) not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table tests
    owner to postgres;

