create table test_direction
(
    test_id      bigint not null
        constraint fk3a1ksxa4aub5usdlusy7ni28j
            references tests,
    direction_id bigint not null
        constraint fkmx51lxbwm5nvglyvny4xtutw4
            references direction
);

alter table test_direction
    owner to postgres;

