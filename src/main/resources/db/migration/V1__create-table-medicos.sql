CREATE TABLE medicos(

    id_medico uuid NOT NULL,
    crm character varying(255),
    email character varying(255),
    bairro character varying(255),
    cep character varying(255),
    cidade character varying(255),
    complemento character varying(255),
    logradouro character varying(255),
    numero character varying(255),
    uf character varying(255),
    especialidade character varying(255),
    nome character varying(255),
    PRIMARY KEY(id_medico)
);