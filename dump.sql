--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4
-- Dumped by pg_dump version 15.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: candidate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.candidate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidate_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: candidate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidate (
    id bigint DEFAULT nextval('public.candidate_id_seq'::regclass) NOT NULL,
    cv_file bytea,
    description character varying(255),
    firstname character varying(255),
    middle_name character varying(255),
    photo bytea DEFAULT pg_read_binary_file('/Загрузки'::text),
    second_name character varying(255)
);


ALTER TABLE public.candidate OWNER TO postgres;

--
-- Name: candidate_direction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidate_direction (
    candidate_id bigint NOT NULL,
    direction_id bigint NOT NULL
);


ALTER TABLE public.candidate_direction OWNER TO postgres;

--
-- Name: candidate_tests_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.candidate_tests_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidate_tests_id_seq OWNER TO postgres;

--
-- Name: candidate_tests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidate_tests (
    id bigint DEFAULT nextval('public.candidate_tests_id_seq'::regclass) NOT NULL,
    result bigint,
    candidate_id bigint,
    tests_id bigint,
    "time" timestamp(6) without time zone DEFAULT now()
);


ALTER TABLE public.candidate_tests OWNER TO postgres;

--
-- Name: direction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.direction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.direction_id_seq OWNER TO postgres;

--
-- Name: direction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direction (
    id bigint DEFAULT nextval('public.direction_id_seq'::regclass) NOT NULL,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.direction OWNER TO postgres;

--
-- Name: test_direction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.test_direction (
    test_id bigint NOT NULL,
    direction_id bigint NOT NULL
);


ALTER TABLE public.test_direction OWNER TO postgres;

--
-- Name: tests_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tests_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tests_id_seq OWNER TO postgres;

--
-- Name: tests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tests (
    id bigint DEFAULT nextval('public.tests_id_seq'::regclass) NOT NULL,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.tests OWNER TO postgres;

--
-- Data for Name: candidate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.candidate (id, cv_file, description, firstname, middle_name, photo, second_name) FROM stdin;
13	\N	Тудасюда	Андрей	Георгиевич	\N	Петросян
9	\N	Хочет на стажировку	Алексей	Вячеславович	\N	Кузнечик
14	\N	Сюдатуда	БелкаPUT	Волковна	\N	Лисьева
\.


--
-- Data for Name: candidate_direction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.candidate_direction (candidate_id, direction_id) FROM stdin;
9	1
\.


--
-- Data for Name: candidate_tests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.candidate_tests (id, result, candidate_id, tests_id, "time") FROM stdin;
6	4	9	1	2024-03-13 14:26:05.06653
\.


--
-- Data for Name: direction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direction (id, description, name) FROM stdin;
1	Perfect1	Java
2	Perfect11	Python
3	Norm	Go
\.


--
-- Data for Name: test_direction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.test_direction (test_id, direction_id) FROM stdin;
1	1
\.


--
-- Data for Name: tests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tests (id, description, name) FROM stdin;
1	1-ое задание	JavaCreateServiceCv
\.


--
-- Name: candidate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.candidate_id_seq', 14, true);


--
-- Name: candidate_tests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.candidate_tests_id_seq', 6, true);


--
-- Name: direction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.direction_id_seq', 3, true);


--
-- Name: tests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tests_id_seq', 1, true);


--
-- Name: candidate candidate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate
    ADD CONSTRAINT candidate_pkey PRIMARY KEY (id);


--
-- Name: candidate_tests candidate_tests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate_tests
    ADD CONSTRAINT candidate_tests_pkey PRIMARY KEY (id);


--
-- Name: direction direction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direction
    ADD CONSTRAINT direction_pkey PRIMARY KEY (id);


--
-- Name: tests tests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_pkey PRIMARY KEY (id);


--
-- Name: candidate_tests fk20mcwjc2m87vx0nojop42augk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate_tests
    ADD CONSTRAINT fk20mcwjc2m87vx0nojop42augk FOREIGN KEY (tests_id) REFERENCES public.tests(id);


--
-- Name: test_direction fk3a1ksxa4aub5usdlusy7ni28j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test_direction
    ADD CONSTRAINT fk3a1ksxa4aub5usdlusy7ni28j FOREIGN KEY (test_id) REFERENCES public.tests(id);


--
-- Name: candidate_direction fkf67p8hdcbnkyolo1u81qpao0g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate_direction
    ADD CONSTRAINT fkf67p8hdcbnkyolo1u81qpao0g FOREIGN KEY (candidate_id) REFERENCES public.candidate(id);


--
-- Name: candidate_direction fkiop3b0cfvy8kkm5827lep42ru; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate_direction
    ADD CONSTRAINT fkiop3b0cfvy8kkm5827lep42ru FOREIGN KEY (direction_id) REFERENCES public.direction(id);


--
-- Name: candidate_tests fklr5o40e60fhpqekllsiefnqgo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidate_tests
    ADD CONSTRAINT fklr5o40e60fhpqekllsiefnqgo FOREIGN KEY (candidate_id) REFERENCES public.candidate(id);


--
-- Name: test_direction fkmx51lxbwm5nvglyvny4xtutw4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test_direction
    ADD CONSTRAINT fkmx51lxbwm5nvglyvny4xtutw4 FOREIGN KEY (direction_id) REFERENCES public.direction(id);


--
-- PostgreSQL database dump complete
--

