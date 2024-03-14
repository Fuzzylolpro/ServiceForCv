create table candidate_tests
(
    id           bigint       default nextval('candidate_tests_id_seq'::regclass) not null
        primary key,
    result       bigint,
    candidate_id bigint
        constraint fklr5o40e60fhpqekllsiefnqgo
            references candidate,
    tests_id     bigint
        constraint fk20mcwjc2m87vx0nojop42augk
            references tests,
    time         timestamp(6) default now()
);

alter table candidate_tests
    owner to postgres;

