# Registro-Elettronico (IN SVILUPPO...)
Emulazione di un registro elettronico per le scuole superiori. 

Il file /src/main/application.properties non è riportato su Github. La struttura è la seguente:
```yaml
spring.application.name=registro-elettronico

server.port=8080

# Configurazione del datasource
spring.datasource.url=jdbc:mysql://localhost:PORT_NUMBER/re?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configurazione JPA/Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

# JWT KEY
jwt.secret=${chiave}
```

Le tecnologie usate sono: 
- DBMS: MySQL
- Backend: Java Spring Boot
- Frontend: React.js

## Autenticazione ed Autorizzazione
L'autenticazione è svolta mediante JWT.
Il sistema prevde 4 tipi di utenti. 
La tabella "utente" ha un riferimento ad ogni tabella dello specifico utente; la gestione delle relazioni e del ruolo è svolta a livello applicativo. 
I ruoli, in ordine decrescente di privilegi sono: gestore, segreteria, docente e studente.

## SQL
Vi è una cartella sql dedicata contenente i file per la creazione, gestione e ottimizzazione della base dati in MySQL.

### Procedure
#### Inserimento utente gestore
Si è creata una procedura per l'inserimento dei valori associati alla tabella ```utente``` con il ruolo di ```GES``` (gestore).
La password può essere generata usando vari <a href="https://bcrypt-generator.com/">modelli online</a> di Bcrypt a 12 rounds. 
Gli utenti, invece, come docente, segreteria e studente sono aggiunti direttamente tramite REST API con autenticazione.

## Back-end
Il back-end è realizzato con il framework Spring Boot in Java.

### SOAP
Servizio Soap implementato per la classe scuola. 
Si aggiungno le dipendenze per JAXB, WSDL e spring-boot-starter-web-services; ovviamente anche il plugin per generare le classi SOAP. SI creano gli XSD, poi si lancia: mvn clean generate-sources. Si crea il file di configurazione WebServiceConfig.java che permette di creare i WSDL a runtime. Infine, si realizzano gli endpoint con i servizi implementati.

### REST
Per il front-end + test con Postman. 
Nello sviluppo back-end si è seguito il pattern MVC: model, repository, dto, mapper, interfaccia service, service e rest controller.

### Spring Security
L'applicazione prevede autenticazione tramite username e password. Le credenziali sono fornite in anticipo agli utenti. 
Gli utenti posono essere creati trami REST API dagli amminstratori; mentre gli admin si creano direttamente tramite SQL. 
A seguito di una corretta autenticazione il back-end inoltra al client il token JWT con cui effettuare le successive chiamate autenticate.  

#### JWT
Si è usata crittografia simmetrica per la generazione della chiave con cui firmare il JWT. Il token fa uso dell'algoritmo di hashing HMAC che, in congiunzione con la firma, garantisce autentenicità ed integrità del token.
La chiave è stata generata mediante il comando:
```bash
openssl rand -base64 64
```

Ecco come appare, per il ruolo di Segreteria, il contenuto del JWT decodificato base-64 (e firmato):

```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlcyI6IlJPTEVfU0VHIiwic3ViIjoiUzEwMSIsImlhdCI6MTc1MjMzMDUwNywiZXhwIjoxNzUyMzMyMzA3fQ.nn34gSzGYS5RO4f8G8JBTEL0SsIy8l8xMCwJhH1BngC-AKVLkSTHtNKahQbGL40jhmB-5LLDDkcbfGpu5tSLOw"
}
```
Si specifica: il ruolo, lo username, la data di emissione e di scadenza del token JWT.
```json
{
  "roles": "ROLE_SEG",
  "sub": "S101",
  "iat": 1752330507,
  "exp": 1752332307
}
```

Nel caso del ruolo di Gestore:
```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlcyI6IlJPTEVfR0VTIiwic3ViIjoiRzEwMCIsImlhdCI6MTc1MjMzMDc5MywiZXhwIjoxNzUyMzMyNTkzfQ.weaMpgu3H_tqPD4HDOEn9AmG4wv83wbgX7Ueh64dwcRh0fWgThBEprqx3Y24rnL-4ptHATDjukIBanaNYt_seg"
}
```
Il payload del JWT decodificato:
```json
{
  "roles": "ROLE_GES",
  "sub": "G100",
  "iat": 1752330793,
  "exp": 1752332593
}
```
#### Ruoli
Nell'applicazione si prevedono 4 tipi di ruoli, da cui dipendono diverse tipi di autorizzazioni:
- Gestore (admin)
- Segreteria (gestisce la scuola di appartenenza, gli studenti ed i docenti)
- Docente (elargisce le funzionalità di un insegnante relative ad una o più classi di studenti)
- Studente (consulta le proprie informazione scolastiche)

## Front-end
Front end dell'applicazione sviluppato con React.

### Creazione progetto
Creazione del progetto nel workspace di Eclipse all'interno della cartella "frontend".

```bash
npx create-vite@latest frontend -- --template react
cd frontend
npm install
```

# Demo
Link: 

# Vulnerabilità
## Broken Access Control - Horizontal Privilage escalation
Link: https://youtu.be/lo9Po2Kzl3c

#### Riferimenti
- <a href="https://www.youtube.com/watch?v=Kq-DRboTVrc">Spring Boot</a>
- <a href="https://fullstackopen.com/en/">React</a> 
- <a href="https://www.youtube.com/watch?v=oeni_9g7too&t=333s">Spring Security</a>
- <a href="https://cs50.harvard.edu/sql/2024/">SQL</a>
- <a href="https://jwt.io/">JWT</a> 
