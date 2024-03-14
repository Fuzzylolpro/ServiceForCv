create table candidate
(
    id          bigint default nextval('candidate_id_seq'::regclass) not null
        primary key,
    cv_file     bytea,
    description varchar(255),
    firstname   varchar(255),
    middle_name varchar(255),
    photo       bytea  default pg_read_binary_file('/Загрузки'::text),
    second_name varchar(255)
);

alter table candidate
    owner to postgres;

