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

/*
CREATE VIEW insegnamento_docenti_per_classe AS 
SELECT d.id_docente, pd.nome, pd.cognome, c.id_classe, c.grado, c.lettera, m.id_materia, m.nome
FROM docente d JOIN profilo_docente ON d.id_docente = pd.id_docente
JOIN incarico i ON d.id_docente = i.id_docente
JOIN classe c ON c.id_classe = i.id_classe
JOIN materia m ON i.id_materia = m.id_materia;

CREATE VIEW voti_per_studente AS
SELECT s.id_studente, sp.nome, sp.cognome, v.voto, v.tipo, v.data_valutazione, m.nome AS materia
FROM studente s JOIN profilo_studente ps ON s.id_studente = sp.id_studente
JOIN valutazione v ON v.id_studente = s.id_studente
JOIN materia m ON  v.id_materia = m.id_materia;
*/

# Mostra tutte le viste del db
SHOW FULL TABLES IN re WHERE TABLE_TYPE LIKE 'VIEW';

##################################
####### INDICI  ##################
##################################

CREATE INDEX idx_classe_id_scuola ON classe(id_scuola); 
CREATE INDEX idx_utente_riferimento_id ON utente(riferimento_id);
CREATE INDEX idx_segreteria_id_scuola ON segreteria(id_scuola);
#CREATE INDEX idx_profilo_studente_id_studente ON profilo_studente(id_studente);
CREATE INDEX idx_studente_id_classe ON studente(id_classe);
CREATE INDEX idx_studente_id_scuola ON studente(id_scuola);
#CREATE INDEX idx_incarico_docente_classe ON incarico(id_docente, id_classe);
#CREATE INDEX idx_valutazione_studente_materia ON valutazione(id_studente, id_materia);

# Mostra indice per tabella
SHOW INDEXES FROM classe;
SHOW INDEXES FROM utente;
SHOW INDEXES FROM segreteria;
SHOW INDEXES FROM  studente;

# Ottimizzazione delle query
EXPLAIN SELECT * FROM classi_per_scuola;
EXPLAIN SELECT * FROM segreterie_per_scuola;
#EXPLAIN SELECT * FROM studenti_per_classe;
#EXPLAIN SELECT * FROM insegnamento_docenti_per_classe;
#EXPLAIN SELECT * FROM voti_per_studente;