CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    last_name VARCHAR (100) NOT NULL,
    phone VARCHAR (15) NOT NULL,
    email VARCHAR (100) NOT NULL,
    username VARCHAR (45) NOT NULL,
    password VARCHAR (45) NOT NULL,
    status VARCHAR (15) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sector (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,

    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS company (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS farmacy(
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    phone VARCHAR (100) NOT NULL,
    address VARCHAR (100) NOT NULL,
    status VARCHAR (100) NOT NULL,
    id_company int,
    id_sector int,

    PRIMARY KEY (id),
    FOREIGN KEY (id_company) REFERENCES company(id),
    FOREIGN KEY (id_sector) REFERENCES sector(id)
);


