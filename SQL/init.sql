DROP DATABASE IF EXISTS bookshop;

CREATE DATABASE bookshop CHARACTER SET utf8mb4;

USE bookshop;

CREATE TABLE adresse (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    strasse VARCHAR(50) NOT NULL,
    zusatz VARCHAR(25),
    plz VARCHAR(5) NOT NULL,
    stadt VARCHAR(50) NOT NULL
);
ALTER TABLE adresse AUTO_INCREMENT=6; --5 Adressen werden beim seeding eingetragen

CREATE TABLE verlag(
    name VARCHAR(50) NOT NULL PRIMARY KEY,
    adressId INT NOT NULL,
    FOREIGN KEY(adressId) REFERENCES adresse(id)
);

CREATE TABLE buch (
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    titel VARCHAR(150) NOT NULL,
    verlag VARCHAR(50) NOT NULL,
    bild LONGBLOB,
    bild_pfad VARCHAR(1024),
    FOREIGN KEY(verlag) REFERENCES verlag(name)
);

CREATE TABLE autor (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    vorname VARCHAR(25) NOT NULL,
    nachname VARCHAR(25) NOT NULL
);
ALTER TABLE autor AUTO_INCREMENT=13; --12 Autors werden beim seeding eingetragen

CREATE TABLE buchautor(
    isbn VARCHAR(13) NOT NULL,
    autorId INT NOT NULL,
    FOREIGN KEY(isbn) REFERENCES buch(isbn),
    FOREIGN KEY(autorId) REFERENCES autor(id)
);

CREATE TABLE buchbestand(
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    bestand DECIMAL(4, 0) NOT NULL CHECK(bestand >= 0),
    FOREIGN KEY(isbn) REFERENCES buch(isbn)
    ON DELETE CASCADE
);

CREATE TABLE kunde(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE privatkunde(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    nachname VARCHAR(25) NOT NULL,
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr)
    ON DELETE CASCADE
);

CREATE TABLE geschaeftskunde(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr)
    ON DELETE CASCADE
);

CREATE TABLE buchpreis(
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    preis DECIMAL(19, 2) NOT NULL CHECK(preis >= 0),
    FOREIGN KEY(isbn) REFERENCES buch(isbn)
    ON DELETE CASCADE
);

CREATE TABLE kundenkauf(
    kundenNr VARCHAR(10) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    datum VARCHAR(50) NOT NULL DEFAULT(CAST(NOW() AS CHAR)),
    menge INT NOT NULL CHECK(menge >= 0) DEFAULT 1,
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr) ON DELETE CASCADE,
    FOREIGN KEY(isbn) REFERENCES buch(isbn)
);

CREATE TABLE kundenadresse(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    adressId INT NOT NULL,
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr),
    FOREIGN KEY(adressId) REFERENCES adresse(id)
);

CREATE TABLE kundenpassword(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    pwdhash BLOB NOT NULL,
    salt BLOB NOT NULL,
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr)
);

DELIMITER $$ 

CREATE TRIGGER sort_kunde
AFTER INSERT ON kunde 
FOR EACH ROW 
    BEGIN 
        BEGIN if (LEFT(NEW.kundenNr,3) = 'PRV') then
        INSERT INTO privatkunde VALUES(NEW.kundenNr, SUBSTRING_INDEX(NEW.name, ' ', 1), SUBSTRING_INDEX(NEW.name, ' ', -1));
        
        ELSE if (LEFT(NEW.kundenNr,3) = 'GEK') then
        INSERT INTO geschaeftskunde VALUES(NEW.kundenNr, NEW.name);
        
        END IF;

        END IF;
        END;
END $$ 

DELIMITER;
