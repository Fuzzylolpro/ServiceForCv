create table candidate_direction
(
    candidate_id bigint not null
        constraint fkf67p8hdcbnkyolo1u81qpao0g
            references candidate,
    direction_id bigint not null
        constraint fkiop3b0cfvy8kkm5827lep42ru
            references direction
);

alter table candidate_direction
    owner to postgres;

