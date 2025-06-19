# Registro-Elettronico
Emulazione di un registro elettronico per le scuole superiori. 

Le tecnologie usate sono: 
- DBMS: MySQL
- Backend: Java Spring Boot
- Frontend: React.js

## Casi d'uso
Il sistema prevde 4 utenti descritti da una tabella "utente" che ha un riferimento alla tabella dello specifico utente gestito a livello applicativo. Si hanno 4 ruoli che si riflettono nella gestione JWT di Spring Security.

### Gestore

### Segreteria

### Docente

### Studente

## SQL
cartella sql dedicata contenente i file per la creazione, gestione e ottimizzazione della base dati in MySQL.

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
