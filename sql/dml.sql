use re;

SELECT * FROM scuola;

INSERT INTO scuola (nome, tipo, indirizzo, citta, provincia, cap, regione)
VALUES 
('Liceo Scientifco Leonardo da Vinci', 'Liceo Scientfico', 'via del carroarmato 19', 'Pisa', 'PI', '56121', 'Toscana'),
('Istituto Tecnico Industriale G. Galilei', 'Istituto Tecnico', 'Via Meccanica 10', 'Milano', 'MI', '20131', 'Lombardia'),
('Liceo Classico Cesare Beccaria', 'Liceo Classico', 'Via Dante 45', 'Torino', 'TO', '10121', 'Piemonte'),
('Istituto Professionale per i Servizi Alberghieri', 'Istituto Professionale', 'Via del Gusto 7', 'Firenze', 'FI', '50125', 'Toscana'),
('Liceo Artistico Kandinsky', 'Liceo Artistico', 'Via dei Colori 12', 'Roma', 'RM', '00184', 'Lazio'),
('Istituto Comprensivo Giovanni XXIII', 'Istituto Comprensivo', 'Via Scuole 5', 'Bari', 'BA', '70121', 'Puglia'),
('Scuola Media Dante Alighieri', 'Scuola Media', 'Piazza Poeti 3', 'Napoli', 'NA', '80121', 'Campania'),
('Liceo Linguistico Internazionale', 'Liceo Linguistico', 'Via delle Lingue 23', 'Verona', 'VR', '37121', 'Veneto'),
('Istituto Tecnico Agrario F. De Sanctis', 'Istituto Tecnico', 'Via delle Vigne 88', 'Avellino', 'AV', '83100', 'Campania'),
('Scuola Elementare Maria Montessori', 'Scuola Primaria', 'Via dei Bambini 1', 'Trieste', 'TS', '34121', 'Friuli Venezia Giulia');

SELECT * FROM classe;

INSERT INTO classe (id_scuola, grado, lettera, anno_scolastico)
VALUES 
(4, 1, 'A', '2025/2026'),
(4, 2, 'A', '2025/2026'),
(4, 3, 'A', '2025/2026'),
(4, 4, 'A', '2025/2026'),
(4, 5, 'A', '2025/2026'),
(4, 1, 'B', '2025/2026'),
(4, 2, 'B', '2025/2026'),
(4, 3, 'B', '2025/2026'),
(4, 4, 'B', '2025/2026'),
(4, 5, 'B', '2025/2026'),
(4, 1, 'C', '2025/2026'),
(4, 2, 'C', '2025/2026'),
(4, 3, 'C', '2025/2026'),
(4, 4, 'C', '2025/2026'),
(4, 5, 'C', '2025/2026'),
(4, 1, 'D', '2025/2026'),
(4, 2, 'D', '2025/2026'),
(4, 3, 'D', '2025/2026'),
(4, 4, 'D', '2025/2026'),
(4, 5, 'D', '2025/2026'),
(4, 1, 'E', '2025/2026'),
(4, 2, 'E', '2025/2026'),
(4, 3, 'E', '2025/2026'),
(4, 4, 'E', '2025/2026'),
(4, 5, 'E', '2025/2026');

SELECT * FROM classi_per_scuola; 

INSERT INTO segreteria (id_scuola, nome) VALUES (4, "Segreteria 1"), (4, "Segreteria 2"), (13, "Segreteria 1"), (13, "Segreteria 2");

SELECT * FROM segreteria;

# Inserimento dei gestori nelle procedure o tramite API
SELECT * FROM utente;

# Segretire per scuola
SELECT * FROM segreterie_per_scuola; 

# Studenti
INSERT INTO studente (id_classe, id_scuola, nome, cognome, email, numero, codice_fiscale, indirizzo, citta, provincia, cap) VALUES 
(1, 1, 'Luca', 'Rossi', 'luca.rossi@example.com', '3201234567', 'RSSLCU01A01H501U', 'Via Roma 12', 'Milano', 'MI', '20100'),
(1, 1, 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', '3407654321','BNCGLI02B02H501W', 'Via Torino 34', 'Milano', 'MI', '20100'),
(36, 3, 'Mario', 'Verdi', 'mario.verdi@example.com', '3887653241','KNFGLD23B06H501F', 'Via Como 34', 'Milano', 'MI', '20100');

SELECT * FROM studente;

# Studenti per classe e scuola
SELECT s.id_studente, s.nome, s.cognome, c.id_classe, c.grado, c.lettera, c.anno_scolastico, sc.id_scuola, sc.nome, sc.citta 
FROM studente s 
JOIN classe c ON s.id_classe = c.id_classe
JOIN scuola sc ON s.id_scuola = sc.id_scuola;

# Studenti per classe definita
SELECT * FROM studenti_per_classe WHERE id_classe=1;
