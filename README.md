# Registro-Elettronico (IN SVILUPPO...)
Emulazione di un registro elettronico per le scuole superiori. 

Le tecnologie usate sono: 
- DBMS: MySQL
- Backend: Java Spring Boot
- Frontend: React.js

## Casi d'uso
Il sistema prevde 4 tipi di utenti. La tabella "utente" ha un riferimento ad ogni tabella dello specifico utente; la gestione delle relazioni e del ruolo è svolta a livello applicativo. 

### Gestore

### Segreteria

### Docente

### Studente

## SQL
Vi è una cartella sql dedicata contenente i file per la creazione, gestione e ottimizzazione della base dati in MySQL.

### Relazioni


### Tabelle

#### Scuola
#### Classe
#### Segreteria

## Servizi

### SOAP
Servizio Soap implementato per la classe scuola. 

### Implementazione
Si aggiungno le dipendenze per JAXB, WSDL e spring-boot-starter-web-services; ovviamente anche il plugin per generare le classi SOAP. SI creano gli XSD, poi si lancia: mvn clean generate-sources. Si crea il file di configurazione WebServiceConfig.java che permette di creare i WSDL a runtime. Infine, si realizzano gli endpoint con i servizi implementati.

### REST
Per il front-end + test con Postman. 

### Implementazione
Nello sviluppo si è seguito il pattern MVC: model, repository, dto, mapper, interfaccia service, service e rest controller.

## Prossimi passi:
-Spring Security JWT per amministratore
-spring batch per caricare classi (csv) avviato tramite REST

### TODO
- SOAP classe
- creare utente meno privilegiato per connessione a db da spring boot
