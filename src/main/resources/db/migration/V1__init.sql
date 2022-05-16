CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    last_name VARCHAR (100) NOT NULL,
    phone VARCHAR (15) NOT NULL,
    email VARCHAR (100) NOT NULL,
    password VARCHAR (45) NOT NULL,
    status VARCHAR (15) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sector (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,
    idUser int,

    PRIMARY KEY (id),
    FOREIGN KEY (idUser) REFERENCES users(id)
);


CREATE TABLE IF NOT EXISTS company (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,
    idUser int,

    PRIMARY KEY (id),
    FOREIGN KEY (idUser) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS farmacy(
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    phone VARCHAR (100) NOT NULL,
    address VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,
    idUser int,
    idCompany int,
    idSector int,

    PRIMARY KEY (id),
    FOREIGN KEY (idUser) REFERENCES users(id),
    FOREIGN KEY (idCompany) REFERENCES company(id),
    FOREIGN KEY (idSector) REFERENCES sector(id)
);


