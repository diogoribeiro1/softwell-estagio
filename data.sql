create database IF NOT EXISTS "softwell_db";
create table IF NOT EXISTS "prv_cliente"(
                                            "id" SERIAL PRIMARY KEY,
                                            "nome" varchar(80) NOT NULL,
    "data_nasc" date NOT NULL,
    "rg" varchar(14) NOT NULL,
    "cpf" varchar(14) NOT NULL,
    "celular" varchar(14) NOT NULL,
    "email" varchar(60),
    "nome_mae" varchar(80) NOT NULL,
    "nome_pai" varchar(80) NOT NULL,
    "data_cadastro" timestamp NOT NULL
    );