use re;

#################################
####### QUERY DI TEST ###########
#################################


#TEST aggiunta e modifica di una classe nella scuola 3
SELECT s.id_scuola, s.nome, s.citta, c.id_classe, c.grado, c.lettera, c.anno_scolastico, c.data_inserimento, c.data_aggiornamento 
FROM scuola s JOIN classe c ON s.id_scuola = c.id_scuola 
WHERE s.id_scuola = 3 ORDER BY grado ASC, lettera ASC;

show indexes from classe;

