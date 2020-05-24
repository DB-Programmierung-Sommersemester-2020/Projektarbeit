DROP DATABASE IF EXISTS bookshop;

CREATE DATABASE bookshop CHARACTER SET utf8mb4;

USE bookshop;

CREATE TABLE adresse (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    strasse VARCHAR(50) NOT NULL,
    zusatz VARCHAR(25),
    plz VARCHAR(5) NOT NULL,
    stadt VARCHAR(50)
);

CREATE TABLE verlag(
    name VARCHAR(50) NOT NULL PRIMARY KEY,
    adressId INT NOT NULL,
    FOREIGN KEY(adressId) REFERENCES adresse(id)
);

CREATE TABLE buch (
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    titel VARCHAR(50) NOT NULL,
    verlag VARCHAR(50) NOT NULL,
    bild LONGBLOB,
    bild_pfad VARCHAR(1024),-- gegebenfalls Pfad zum Bild
    FOREIGN KEY(verlag) REFERENCES verlag(name)
);

CREATE TABLE autor (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    vorname VARCHAR(25) NOT NULL,
    nachname VARCHAR(25) NOT NULL
);

CREATE TABLE buchbestand(
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    bestand DECIMAL(4, 0) CHECK(bestand >= 0),
    FOREIGN KEY(isbn) REFERENCES buch(isbn)
    ON DELETE CASCADE
);

/* Fuer das Abspeichern von Kunde wird aktuell nur Kunde und Privatkunde verwendet 
 die Gedanken beim Entwurf von Kundenhierarchie waren, ersmal Kunde in 
 Kunden - Tabelle abzuspeichern und dannach ausgegangen aus z.B. Primaerschlussel,
 welches bei Privatkunde mit PRV_____ und bei der Geschaeftskunde mit z.B GEK_____ beginnt,
 mit einem Trigger (AFTER INCERT...) aussortieren. Da die Auswahlmoeglichkeit in Registrierungsmaske
 noch nicht gegeben ist, wird es erstmal wie beschrieben gespeichert 
 Primaerschluessel fuer Kunden - Tabelen, wird spaeter in JavaCode generiert.
 Fuer die Sortierung ist ein Trigger schon gegeben siehe unten*/

CREATE TABLE kunde(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
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
    preis DECIMAL(3, 2) NOT NULL CHECK(preis >= 0),
    FOREIGN KEY(isbn) REFERENCES buch(isbn)
    ON DELETE CASCADE
);

CREATE TABLE kundenkauf(
    kundenNr VARCHAR(10) NOT NULL PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL,
    menge INT NOT NULL CHECK(menge >= 0),
    FOREIGN KEY(kundenNr) REFERENCES kunde(kundenNr) ON DELETE CASCADE,
    FOREIGN KEY(isbn) REFERENCES buchpreis(isbn)
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