use re;

##################################
####### CREAZIONE VISTE  #########
##################################

CREATE VIEW classi_per_scuola AS
SELECT s.id_scuola, s.tipo, s.nome, s.indirizzo, s.citta, s.provincia, c.id_classe, c.grado, c.lettera, c.anno_scolastico
FROM scuola s JOIN classe c ON c.id_scuola = s.id_scuola;

CREATE VIEW segreterie_per_scuola AS
SELECT se.id_scuola, sc.nome AS "scuola", se.id_segreteria, se.nome AS "nome segreteria", u.id_utente, u.username, u.ruolo  
FROM segreteria se JOIN scuola sc ON se.id_scuola = sc.id_scuola
JOIN utente u ON u.riferimento_id = se.id_segreteria;

CREATE VIEW studenti_per_classe AS
SELECT s.id_studente, s.nome, s.cognome, c.id_classe, c.grado, c.lettera
FROM studente s JOIN classe c ON c.id_classe = s.id_classe;

CREATE VIEW docenti_per_scuola AS
SELECT DISTINCT d.id_docente, d.nome, d.cognome, s.id_scuola, s.nome AS "nome scuola", s.citta
FROM docente d JOIN incarico i ON i.id_docente = d.id_docente
JOIN scuola s ON i.id_scuola = s.id_scuola;

CREATE VIEW insegnamento_docenti_per_classe AS 
SELECT i.id_incarico, d.id_docente, d.nome, d.cognome, c.id_classe, c.grado, c.lettera, c.anno_scolastico, m.id_materia, m.nome AS materia 
FROM docente d JOIN incarico i ON d.id_docente = i.id_docente
JOIN classe c ON c.id_classe = i.id_classe
JOIN materia m ON i.id_materia = m.id_materia;

CREATE VIEW compiti_per_incarico AS
SELECT c.id_compito, m.nome materia, d.cognome docente,  c.esercizi, c.data_consegna, 
s.nome scuola, concat(cl.grado, cl.lettera) classe, cl.anno_scolastico, i.id_incarico  
FROM compiti c JOIN incarico i ON c.id_incarico = i.id_incarico
JOIN scuola s ON s.id_scuola = i.id_scuola
JOIN classe cl ON cl.id_classe = i.id_classe
JOIN docente d ON d.id_docente = i.id_docente
JOIN materia m ON m.id_materia = i.id_materia;

CREATE VIEW voti_studenti_per_scuola_e_classe AS
SELECT id_valutazione, sc.nome scuola, concat(c.grado, c.lettera) classe, c.anno_scolastico, m.nome materia, d.cognome docente, v.voto,
 v.tipo, concat(s.cognome, ' ', s.nome) studente, v.data_valutazione, c.id_classe, sc.id_scuola, d.id_docente, m.id_materia
FROM valutazione v JOIN studente s ON v.id_studente = s.id_studente
JOIN incarico i ON v.id_incarico = i.id_incarico
JOIN classe c ON c.id_classe = s.id_classe
JOIN scuola sc ON sc.id_scuola = s.id_scuola
JOIN docente d ON d.id_docente = i.id_docente
JOIN materia m ON m.id_materia = i.id_materia;


# Mostra tutte le viste del db
SHOW FULL TABLES IN re WHERE TABLE_TYPE LIKE 'VIEW';

##################################
####### INDICI  ##################
##################################

CREATE INDEX idx_classe_id_scuola ON classe(id_scuola); 
CREATE INDEX idx_utente_riferimento_id ON utente(riferimento_id);
CREATE INDEX idx_segreteria_id_scuola ON segreteria(id_scuola);
CREATE INDEX idx_studente_id_classe ON studente(id_classe);
CREATE INDEX idx_studente_id_scuola ON studente(id_scuola);
CREATE INDEX idx_incarico_docente_classe_materia ON incarico(id_docente, id_classe, id_materia);
CREATE INDEX idx_compiti_id_incarico ON compiti(id_incarico);
CREATE INDEX idx_valutazione_studente ON valutazione(id_studente);

# Mostra indice per tabella
SHOW INDEXES FROM classe;
SHOW INDEXES FROM utente;
SHOW INDEXES FROM segreteria;
SHOW INDEXES FROM  studente;
SHOW INDEXES FROM incarico;
SHOW INDEXES FROM compiti;

# Ottimizzazione delle query
EXPLAIN SELECT * FROM classi_per_scuola;
EXPLAIN SELECT * FROM segreterie_per_scuola;
#EXPLAIN SELECT * FROM studenti_per_classe;
#EXPLAIN SELECT * FROM insegnamento_docenti_per_classe;
#EXPLAIN SELECT * FROM voti_per_studente;