use re;

##################################
####### CREAZIONE PROCEDURE ######
##################################

# Procedura inserimento utente gestore
DELIMITER //
CREATE PROCEDURE inserimento_utente_gestore(
	IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
) 
BEGIN 
	DECLARE last_id INT;
    
    -- inserismento nuovo utente di tipo gestore
	INSERT INTO utente (username, password, ruolo, riferimento_id)
	VALUES (p_username, p_password, 'GES', 0);
    
    -- recupera l'id appena creato
	SET last_id = LAST_INSERT_ID();
    
    -- aggiorna il riferimento_id con l'id del gestore stesso
	UPDATE utente SET riferimento_id = last_id WHERE id_utente = last_id;
    
END //

DELIMITER ;

-- chiamata della procedura
CALL inserimento_utente_gestore('G100', '$2a$12$cgW2S7kbmA/NyN26q3XRXuT9rE4T4RlwxcAnlodY5oXfM1ApBFwGa');
