# Registro-Elettronico
Registro elettronico per le scuole superiori. Realizzazione del progetto Spring Boot: https://start.spring.io/

## Tabelle e Servizi
migration.sql file per la creazione della base dati.

Tabelle "scuola" e "classe" riempite tramite SQL e/o SOAP.

## Librerie usate
- lombok per la generazione del costruttore e dei getter/setter. Su Eclipse bisogna scaricare ed installare il jar: https://projectlombok.org/download e successivamente chiudere ed riaprire l'IDE.

## SOAP
Si aggiungno le dipendenze per JAXB, WSDL e spring-boot-starter-web-services; ovviamente anche il plugin per generare le classi SOAP. SI creano gli XSD, poi si lancia: mvn clean generate-sources. Si crea il file di configurazione WebServiceConfig.java che permette di creare i WSDL a runtime. Infine, si realizzano gli endpoint con i servizi implementati.

## REST
Metodi GET per scuola (+ request param) 

## Prossimi passi:
-Spring Security JWT per amministratore
-validazione DTO
-metodi HTTP per scuola e classe 
-spring batch per caricare classi (csv) avviato tramite REST
-casi d'uso per utente "amministratore"
-aggiungere gestione delle eccezioni: handleDataIntegrity, IllegalArgumentException e ConstraintViolationException
-React con login e gestione tabelle scuola e classe per amministratore


### TODO
- SOAP classe
- mapperDTO
- creare utente meno privilegiato per connessione a db da spring boot
