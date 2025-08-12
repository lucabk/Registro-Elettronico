#CREATE DATABASE re;
USE re;

##################################
####### CREAZIONE TABELLE ########
##################################

CREATE TABLE IF NOT EXISTS scuola(
	id_scuola INT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL,
    citta VARCHAR(50) NOT NULL,
    provincia VARCHAR(10) NOT NULL,
    cap CHAR(5) NOT NULL,
    regione VARCHAR(50) NOT NULL,
	data_inserimento TIMESTAMP DEFAULT NOW(),
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_scuola),
    CHECK (LENGTH(cap) = 5),
    CHECK (LENGTH(provincia) = 2)
);

CREATE TABLE IF NOT EXISTS classe(
	id_classe INT UNSIGNED AUTO_INCREMENT,
    id_scuola INT UNSIGNED,
    grado TINYINT NOT NULL, 
    lettera VARCHAR(5) NOT NULL,
    anno_scolastico VARCHAR(10) NOT NULL,
	data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_classe),
    FOREIGN KEY (id_scuola) REFERENCES scuola(id_scuola),
    CHECK (grado IN (1, 2, 3, 4, 5))
);

CREATE TABLE IF NOT EXISTS compiti(
	id_compito INT UNSIGNED AUTO_INCREMENT,
    id_incarico INT UNSIGNED,
    esercizi TEXT NOT NULL,
	data_consegna DATE NOT NULL,
	data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_compito),
    FOREIGN KEY (id_incarico) REFERENCES incarico(id_incarico)
);

CREATE TABLE IF NOT EXISTS verifica(
	id_verifica INT UNSIGNED AUTO_INCREMENT,
    tipo ENUM('scritto', 'orale') NOT NULL,
	id_incarico INT UNSIGNED,
    argomenti TEXT NOT NULL,
    data_verifica DATE NOT NULL,
	data_inserimento TIMESTAMP DEFAULT NOW(),
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_verifica),
    FOREIGN KEY (id_incarico) REFERENCES incarico(id_incarico)
);

CREATE TABLE studente(
	id_studente INT UNSIGNED AUTO_INCREMENT,
    id_classe INT UNSIGNED,
    id_scuola INT UNSIGNED,
    nome VARCHAR(50) NOT NULL,	
    cognome VARCHAR(50) NOT NULL,	
    email VARCHAR(50) UNIQUE NOT NULL,
    numero VARCHAR(15) UNIQUE,
    codice_fiscale CHAR(16) UNIQUE NOT NULL,
	indirizzo VARCHAR(100) NOT NULL,
    citta VARCHAR(50) NOT NULL,
    provincia VARCHAR(10) NOT NULL,
    cap CHAR(5) NOT NULL,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (LENGTH(cap) = 5),
    CHECK (LENGTH(provincia) = 2),
    CHECK (LENGTH(codice_fiscale) = 16),
    PRIMARY KEY (id_studente),
    FOREIGN KEY (id_classe) REFERENCES classe(id_classe),
    FOREIGN KEY (id_scuola) REFERENCES scuola(id_scuola)
);

CREATE TABLE IF NOT EXISTS valutazione(
	id_valutazione INT UNSIGNED AUTO_INCREMENT,
    id_studente INT UNSIGNED,
    id_incarico INT UNSIGNED,
    voto TINYINT(2) UNSIGNED NOT NULL,
    tipo ENUM('scritto', 'orale') NOT NULL,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_valutazione),
    FOREIGN KEY (id_studente) REFERENCES studente(id_studente),
    FOREIGN KEY (id_incarico) REFERENCES incarico(id_incarico),
    CHECK (voto >= 0 AND voto <= 10)
);

CREATE TABLE IF NOT EXISTS assenza(
	id_assenza INT UNSIGNED AUTO_INCREMENT,
    id_studente INT UNSIGNED,
    giustificata BOOLEAN DEFAULT FALSE,
    tipo ENUM('parziale', 'intera') DEFAULT 'intera',
	data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_assenza),
    FOREIGN KEY (id_studente) REFERENCES studente(id_studente)
);

CREATE TABLE IF NOT EXISTS docente(
	id_docente INT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,	
    cognome VARCHAR(50) NOT NULL,	
    email VARCHAR(50) UNIQUE NOT NULL,
    numero VARCHAR(15) UNIQUE NOT NULL,
    codice_fiscale CHAR(16) UNIQUE NOT NULL,
	indirizzo VARCHAR(100) NOT NULL,
    citta VARCHAR(50) NOT NULL,
    provincia VARCHAR(10) NOT NULL,
    cap CHAR(5) NOT NULL,
    istruzione TEXT NOT NULL,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_docente),
	CHECK (LENGTH(cap) = 5),
    CHECK (LENGTH(provincia) = 2),
    CHECK (LENGTH(codice_fiscale) = 16)
);

CREATE TABLE IF NOT EXISTS materia(
	id_materia INT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    codice VARCHAR(10) NOT NULL UNIQUE,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_materia)
);

CREATE TABLE IF NOT EXISTS incarico(
	id_incarico INT UNSIGNED AUTO_INCREMENT,
    id_scuola INT UNSIGNED,
	id_classe INT UNSIGNED,
    id_docente INT UNSIGNED,
    id_materia INT UNSIGNED,
    programma TEXT NOT NULL ,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_incarico),
    FOREIGN KEY (id_scuola) REFERENCES scuola(id_scuola),
    FOREIGN KEY (id_classe) REFERENCES classe(id_classe),
    FOREIGN KEY (id_docente) REFERENCES docente(id_docente),
    FOREIGN KEY (id_materia) REFERENCES materia(id_materia),
    UNIQUE(id_scuola, id_classe, id_materia)
);

CREATE TABLE IF NOT EXISTS segreteria(
	id_segreteria INT UNSIGNED AUTO_INCREMENT,
    id_scuola INT UNSIGNED,
    nome VARCHAR(100) NOT NULL,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_segreteria),
    FOREIGN KEY (id_scuola) REFERENCES scuola(id_scuola)
);

# Per popolare questa tabella si usa l'id generato da una insert in una delle tabelle segreteria, 
# docente e studente e lo si salva in riferimento_id specificando il ruolo del nuovo utente (per gestore = 0)
CREATE TABLE IF NOT EXISTS utente(
	id_utente INT UNSIGNED AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,	
    ruolo ENUM('GES', 'SEG', 'DOC', 'STU') NOT NULL,
    riferimento_id INT UNSIGNED NOT NULL UNIQUE,
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_aggiornamento TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_utente),
    UNIQUE (ruolo, riferimento_id)
);
