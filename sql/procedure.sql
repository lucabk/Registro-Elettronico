use re;

##################################
####### CREAZIONE PROCEDURE ######
##################################

# CREATE PROCEDURE name BEGIN END;

############################# FARE PROCEDURA INSERIMENTO GESTORE

-- Step 1: inserisci
INSERT INTO utente (username, password, ruolo, riferimento_id)
VALUES ('user2', 'user2', 'GES', 0);

-- Step 2: recupera l'id appena creato
SET @last_id = LAST_INSERT_ID();

-- Step 3: aggiorna riferimento_id con id stesso
UPDATE utente SET riferimento_id = @last_id WHERE id_utente = @last_id;

########################
#TODO: trigger, logs
########################