create table direction
(
    id          bigint default nextval('direction_id_seq'::regclass) not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table direction
    owner to postgres;

