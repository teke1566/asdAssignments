--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-07 17:41:34

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 16577)
-- Name: appointment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.appointment (
    appt_id integer NOT NULL,
    patient_id integer,
    dentist_id integer,
    surgery_id integer,
    date date,
    "time" time without time zone
);


ALTER TABLE public.appointment OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16576)
-- Name: appointment_appt_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.appointment_appt_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.appointment_appt_id_seq OWNER TO postgres;

--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 221
-- Name: appointment_appt_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.appointment_appt_id_seq OWNED BY public.appointment.appt_id;


--
-- TOC entry 216 (class 1259 OID 16556)
-- Name: dentist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dentist (
    dentist_id integer NOT NULL,
    first_name character varying(50),
    last_name character varying(50),
    phone character varying(15),
    email character varying(100),
    specialization character varying(100)
);


ALTER TABLE public.dentist OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16555)
-- Name: dentist_dentist_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dentist_dentist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dentist_dentist_id_seq OWNER TO postgres;

--
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 215
-- Name: dentist_dentist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dentist_dentist_id_seq OWNED BY public.dentist.dentist_id;


--
-- TOC entry 218 (class 1259 OID 16563)
-- Name: patient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.patient (
    patient_id integer NOT NULL,
    first_name character varying(50),
    last_name character varying(50),
    phone character varying(15),
    email character varying(100),
    mailing_address character varying(255),
    dob date
);


ALTER TABLE public.patient OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16562)
-- Name: patient_patient_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.patient_patient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.patient_patient_id_seq OWNER TO postgres;

--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 217
-- Name: patient_patient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.patient_patient_id_seq OWNED BY public.patient.patient_id;


--
-- TOC entry 220 (class 1259 OID 16570)
-- Name: surgery; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.surgery (
    surgery_id integer NOT NULL,
    name character varying(100),
    location character varying(100),
    address character varying(255),
    phone character varying(15)
);


ALTER TABLE public.surgery OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16569)
-- Name: surgery_surgery_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.surgery_surgery_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.surgery_surgery_id_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 219
-- Name: surgery_surgery_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.surgery_surgery_id_seq OWNED BY public.surgery.surgery_id;


--
-- TOC entry 4706 (class 2604 OID 16580)
-- Name: appointment appt_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment ALTER COLUMN appt_id SET DEFAULT nextval('public.appointment_appt_id_seq'::regclass);


--
-- TOC entry 4703 (class 2604 OID 16559)
-- Name: dentist dentist_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dentist ALTER COLUMN dentist_id SET DEFAULT nextval('public.dentist_dentist_id_seq'::regclass);


--
-- TOC entry 4704 (class 2604 OID 16566)
-- Name: patient patient_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient ALTER COLUMN patient_id SET DEFAULT nextval('public.patient_patient_id_seq'::regclass);


--
-- TOC entry 4705 (class 2604 OID 16573)
-- Name: surgery surgery_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.surgery ALTER COLUMN surgery_id SET DEFAULT nextval('public.surgery_surgery_id_seq'::regclass);


--
-- TOC entry 4868 (class 0 OID 16577)
-- Dependencies: 222
-- Data for Name: appointment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.appointment (appt_id, patient_id, dentist_id, surgery_id, date, "time") FROM stdin;
1	1	1	1	2024-04-10	09:00:00
2	2	2	2	2024-04-12	10:30:00
\.


--
-- TOC entry 4862 (class 0 OID 16556)
-- Dependencies: 216
-- Data for Name: dentist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dentist (dentist_id, first_name, last_name, phone, email, specialization) FROM stdin;
1	John	Smith	1234567890	john.smith@example.com	General Dentistry
2	Emily	Johnson	0987654321	emily.johnson@example.com	Orthodontics
\.


--
-- TOC entry 4864 (class 0 OID 16563)
-- Dependencies: 218
-- Data for Name: patient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.patient (patient_id, first_name, last_name, phone, email, mailing_address, dob) FROM stdin;
1	Alice	Brown	1112223333	alice.brown@example.com	123 Main St, City, State	1990-05-15
2	Bob	Davis	4445556666	bob.davis@example.com	456 Elm St, City, State	1985-10-20
\.


--
-- TOC entry 4866 (class 0 OID 16570)
-- Dependencies: 220
-- Data for Name: surgery; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.surgery (surgery_id, name, location, address, phone) FROM stdin;
1	City Dental Clinic	City	789 Oak St, City, State	5551112222
2	Suburb Dental Care	Suburb	456 Maple Ave, Suburb, State	5553334444
\.


--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 221
-- Name: appointment_appt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.appointment_appt_id_seq', 2, true);


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 215
-- Name: dentist_dentist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dentist_dentist_id_seq', 2, true);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 217
-- Name: patient_patient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.patient_patient_id_seq', 2, true);


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 219
-- Name: surgery_surgery_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.surgery_surgery_id_seq', 2, true);


--
-- TOC entry 4714 (class 2606 OID 16582)
-- Name: appointment appointment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (appt_id);


--
-- TOC entry 4708 (class 2606 OID 16561)
-- Name: dentist dentist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dentist
    ADD CONSTRAINT dentist_pkey PRIMARY KEY (dentist_id);


--
-- TOC entry 4710 (class 2606 OID 16568)
-- Name: patient patient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (patient_id);


--
-- TOC entry 4712 (class 2606 OID 16575)
-- Name: surgery surgery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.surgery
    ADD CONSTRAINT surgery_pkey PRIMARY KEY (surgery_id);


--
-- TOC entry 4715 (class 2606 OID 16588)
-- Name: appointment appointment_dentist_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_dentist_id_fkey FOREIGN KEY (dentist_id) REFERENCES public.dentist(dentist_id);


--
-- TOC entry 4716 (class 2606 OID 16583)
-- Name: appointment appointment_patient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES public.patient(patient_id);


--
-- TOC entry 4717 (class 2606 OID 16593)
-- Name: appointment appointment_surgery_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_surgery_id_fkey FOREIGN KEY (surgery_id) REFERENCES public.surgery(surgery_id);


-- Completed on 2024-04-07 17:41:34

--
-- PostgreSQL database dump complete
--

