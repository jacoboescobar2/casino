CREATE TABLE roulettes (
id INT NOT NULL PRIMARY KEY auto_increment,
state BOOLEAN NOT NULL,
open DATETIME NULL,
closed DATETIME NULL 
);

CREATE TABLE numbers (
id INT NOT NULL PRIMARY KEY auto_increment,
number INT NOT NULL,
color VARCHAR(40) NOT NULL,
rouletteid INT,
CONSTRAINT fk_roulette FOREIGN KEY (rouletteid) REFERENCES roulettes(id)
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
date DATETIME NOT NULL,
win BOOLEAN NULL,
colorresult VARCHAR(40) NULL,
numberresult INT NULL,
userid INT,
rouletteid INT,
CONSTRAINT fk_user FOREIGN KEY (userid) REFERENCES users(id),
CONSTRAINT fk_roulette_bet FOREIGN KEY (rouletteid) REFERENCES roulettes(id)
);