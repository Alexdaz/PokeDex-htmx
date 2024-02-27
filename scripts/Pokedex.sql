CREATE TABLE PokemonConsultado
(
    IdPokemonConsultado INTEGER PRIMARY KEY,
    Nombre VARCHAR2(120) NOT NULL,
    Tipo_1 VARCHAR2(70) NOT NULL,
    Tipo_2 VARCHAR2(70) NULL,
    NoPokedex NUMBER NOT NULL,
    ExpBase NUMBER NULL,
    Altura FLOAT NULL,
    Peso NUMBER NULL
);
