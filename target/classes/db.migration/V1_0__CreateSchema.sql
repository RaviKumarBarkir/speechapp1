--Create SCHEMA SPEACH;

CREATE TABLE speach
(
    id character varying(255) NOT NULL,
    body character varying(255) COLLATE pg_catalog."default",
    author character varying(255) COLLATE pg_catalog."default",
    created_date character varying(255) COLLATE pg_catalog."default",
    subject character varying(255) COLLATE pg_catalog."default"
    CONSTRAINT investor_pkey PRIMARY KEY (id)
);

ALTER TABLE speach OWNER to postgres;