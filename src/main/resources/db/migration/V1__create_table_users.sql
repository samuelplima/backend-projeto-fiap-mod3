
CREATE SCHEMA IF NOT EXISTS vivo;

CREATE TABLE IF NOT EXISTS vivo.usuario(
                             id bigserial NOT NULL PRIMARY KEY,
                             nome character varying(150),
                             email character varying(100),
                             cpf character varying(14),
                             telefone character varying(11),
                             senha character varying(255),
                             data_cadastro date default now()
);
