CREATE TABLE roulettes (
id INT NOT NULL PRIMARY KEY auto_increment,
estate BOOLEAN NOT NULL
);

CREATE TABLE numbers (
id INT NOT NULL PRIMARY KEY auto_increment,
number INT NOT NULL,
color VARCHAR(40) NOT NULL
);

CREATE TABLE boards (
id INT NOT NULL PRIMARY KEY auto_increment,
rouletteid INT REFERENCES roulettes(id),
numbersid INT REFERENCES numbers(number)
);

CREATE TABLE users (
id INT NOT NULL PRIMARY KEY auto_increment,
name VARCHAR(500) NOT NULL,
money DOUBLE NOT NULL
);

CREATE TABLE bets (
id INT NOT NULL PRIMARY KEY auto_increment,
bet DOUBLE NOT NULL,
number INT NULL,
color VARCHAR(40) NULL,
userid INT REFERENCES users(id),
rouletteid INT REFERENCES roulettes(id)
);