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
SELECT * FROM segreterie_per_scuola WHERE id_scuola = 1; 

# Studenti
INSERT INTO studente (id_classe, id_scuola, nome, cognome, email, numero, codice_fiscale, indirizzo, citta, provincia, cap) VALUES 
(1, 1, 'Luca', 'Rossi', 'luca.rossi@example.com', '3201234567', 'RSSLCU01A01H501U', 'Via Roma 12', 'Milano', 'MI', '20100'),
(1, 1, 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', '3407654321','BNCGLI02B02H501W', 'Via Torino 34', 'Milano', 'MI', '20100'),
(36, 3, 'Mario', 'Verdi', 'mario.verdi@example.com', '3887653241','KNFGLD23B06H501F', 'Via Como 34', 'Milano', 'MI', '20100');

SELECT * FROM studente;

# Studenti per classe e scuola
SELECT sc.id_scuola, sc.nome, sc.citta, c.id_classe, c.grado, c.lettera, c.anno_scolastico, s.id_studente, s.nome, s.cognome   
FROM studente s 
JOIN classe c ON s.id_classe = c.id_classe
JOIN scuola sc ON s.id_scuola = sc.id_scuola
WHERE sc.id_scuola=1;

# Studenti per classe definita
SELECT * FROM studenti_per_classe WHERE id_classe=1;

# Account studenti
SELECT s.id_studente, s.id_classe, s.id_scuola, s.nome, s.cognome, u.id_utente, u.username, u.password, u.ruolo, u.riferimento_id 
FROM studente s JOIN utente u ON s.id_studente = u.riferimento_id 
WHERE ruolo = 'STU';

SELECT * FROM utente WHERE ruolo = 'STU';
SELECT * FROM studente;

# Docente
INSERT INTO docente (nome, cognome, email, numero, codice_fiscale, indirizzo, citta, provincia, cap, istruzione)
VALUES ('Luigi', 'Annibale', 'luigi.annibale@mail.com', '3404224169', 'LGNNBU01A01H503T', 'Via Rimini 43', 'Milano', 'MI', '20100', 'LM Storia Contemporanea');

INSERT INTO docente (nome, cognome, email, numero, codice_fiscale, indirizzo, citta, provincia, cap, istruzione)
VALUES
('Giulia', 'Moretti', 'giulia.moretti@mail.com', '3451234567', 'GLMRTT89C41H501D', 'Via Napoli 12', 'Roma', 'RM', '00100', 'LM Lettere'),
('Marco', 'Milani', 'marco.milani@mail.com', '3311122334', 'MRCLNN85D22H501K', 'Viale Italia 15', 'Firenze', 'FI', '50100', 'LM Matematica'),
('Elisa', 'Martini', 'elisa.martini@mail.com', '3399988776', 'LSMRTN78A01H703L', 'Via Torino 99', 'Torino', 'TO', '10100', 'LM Chimica'),
('Francesco', 'Mancini', 'francesco.mancini@mail.com', '3201234567', 'FRNMNC75T12H501F', 'Via Verdi 4', 'Bologna', 'BO', '40100', 'LM Fisica'),
('Alessia', 'Marchetti', 'alessia.marchetti@mail.com', '3276543210', 'LSSMCH90B11H501J', 'Via Dante 17', 'Genova', 'GE', '16100', 'LM Scienze Naturali'),
('Paolo', 'Rossi', 'paolo.rossi@mail.com', '3489998877', 'PLRSSI80C20H501Z', 'Piazza Libertà 6', 'Padova', 'PD', '35100', 'LM Filosofia'),
('Chiara', 'Bianchi', 'chiara.bianchi@mail.com', '3498765432', 'CHRBNC82D45H501A', 'Via Roma 22', 'Trieste', 'TS', '34100', 'LM Biologia'),
('Stefano', 'Verdi', 'stefano.verdi@mail.com', '3361112233', 'STFVRD79T13H501M', 'Via Milano 55', 'Milano', 'MI', '20100', 'LM Informatica'),
('Marta', 'Conti', 'marta.conti@mail.com', '3334445566', 'MRTCNT88S21H501H', 'Via Venezia 8', 'Venezia', 'VE', '30100', 'LM Lingue'),
('Luca', 'Gallo', 'luca.gallo@mail.com', '3345556677', 'LCGLLL81B15H501E', 'Via Po 1', 'Torino', 'TO', '10100', 'LM Matematica'),
('Sara', 'Ferrari', 'sara.ferrari@mail.com', '3356667788', 'SRFRRR93R31H501Y', 'Viale Marconi 2', 'Roma', 'RM', '00100', 'LM Storia dell’Arte'),
('Davide', 'Romano', 'davide.romano@mail.com', '3377778899', 'DVDRMN84L12H501S', 'Via Emilia 3', 'Parma', 'PR', '43100', 'LM Geografia'),
('Angela', 'Testa', 'angela.testa@mail.com', '3218889990', 'NGLTST87T20H501Q', 'Via Garibaldi 77', 'Napoli', 'NA', '80100', 'LM Filosofia'),
('Nicola', 'Ricci', 'nicola.ricci@mail.com', '3229990001', 'NCLRCC74H19H501G', 'Via Lecco 30', 'Lecco', 'LC', '23900', 'LM Fisica'),
('Roberta', 'De Luca', 'roberta.deluca@mail.com', '3231112233', 'RBRDLC91C23H501W', 'Via Lazio 5', 'Latina', 'LT', '04100', 'LM Biotecnologie'),
('Giovanni', 'Parisi', 'giovanni.parisi@mail.com', '3242223344', 'GVNPRS83A01H501R', 'Via Palermo 18', 'Palermo', 'PA', '90100', 'LM Matematica'),
('Elena', 'Neri', 'elena.neri@mail.com', '3253334455', 'LNNNRI85F29H501X', 'Via Savona 10', 'Savona', 'SV', '17100', 'LM Fisica'),
('Federico', 'Silvestri', 'federico.silvestri@mail.com', '3264445566', 'FDRSLV90G12H501V', 'Via Udine 7', 'Udine', 'UD', '33100', 'LM Lettere'),
('Camilla', 'Gatti', 'camilla.gatti@mail.com', '3285556677', 'CMLGTT92L10H501C', 'Via Como 2', 'Como', 'CO', '22100', 'LM Scienze Naturali');


# Account docenti
SELECT d.id_docente, d.nome, d.cognome, u.id_utente, u.username, u.password, u.ruolo, u.riferimento_id 
FROM docente d JOIN utente u ON d.id_docente= u.riferimento_id 
WHERE ruolo = 'DOC';

SELECT * FROM docente;
SELECT * FROM utente WHERE ruolo = 'DOC';
SELECT COUNT(1) AS "Docenti nel db" FROM docente;
SELECT COUNT(1) AS "Utenti docente nel db" FROM utente WHERE ruolo = 'DOC';

# Materia
INSERT INTO materia (nome, codice)
VALUES 
('Matematica', 'MAT01'),
('Fisica', 'FIS01'),
('Italiano', 'ITA01');

SELECT * FROM materia;

# Incarico
INSERT INTO incarico (id_scuola, id_classe, id_docente, id_materia, programma)
VALUES (1, 1, 3, 1, 'Algebra, Geometria, Integrali, Calcolo delle probabilità'); 

SELECT * FROM incarico;

# Docenti per scuola-classe-materia
SELECT * FROM docenti_per_scuola;
SELECT * FROM insegnamento_docenti_per_classe WHERE id_classe = 1; 

# Scuola-Classe-Docente-Materia
SELECT i.id_incarico, s.id_scuola, s.nome, c.id_classe, c.grado, c.lettera, c.anno_scolastico, d.id_docente, d.nome, d.cognome, m.id_materia, m.nome AS materia, i.programma
FROM incarico i JOIN scuola s ON s.id_scuola = i.id_scuola 
JOIN classe c ON c.id_classe = i.id_classe
JOIN docente d ON d.id_docente = i.id_docente
JOIN materia m ON m.id_materia = i.id_materia;
#WHERE c.id_classe = 1;

# Compiti
INSERT INTO compiti (id_incarico, esercizi, data_consegna)
VALUES (9, 'Storia della II Guerra Mondiale, Pearson 2004', '2025-09-26');

SELECT * FROM compiti;
SELECT * FROM compiti_per_incarico ORDER BY id_compito ASC;

# Verifiche 
INSERT INTO verifica (tipo, id_incarico, argomenti, data_verifica)
VALUES ('orale', 9, 'Interrogazioni II Guerra Mondiale', '2025-09-15');

SELECT * FROM verifica;
SELECT id_verifica, d.cognome docente, m.nome materia, v.tipo, v.argomenti, v.data_verifica, concat(c.grado, c.lettera) classe, s.nome scuola, s.citta, c.anno_scolastico 
FROM verifica v JOIN incarico i ON v.id_incarico = i.id_incarico
JOIN classe c ON c.id_classe = i.id_classe
JOIN docente d ON d.id_docente = i.id_docente
JOIN materia m ON m.id_materia = i.id_materia
JOIN scuola s ON s.id_scuola = i.id_scuola;