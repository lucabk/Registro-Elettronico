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

```

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

#### Procedure
### Inserimento utente gestore
Si è creata una procedura per l'inserimento dei valori associati alla tabella ```utente``` con il ruolo di ```GES``` (gestore).
La password può essere generata usando vari <a href="https://bcrypt-generator.com/">modelli online</a> di Bcrypt a 12 rounds. 
Gli utenti, invece, come docente, segreteria e studente sono aggiunti direttamente tramite REST API con autenticazione.

## Servizi

### SOAP
Servizio Soap implementato per la classe scuola. 

### Implementazione
Si aggiungno le dipendenze per JAXB, WSDL e spring-boot-starter-web-services; ovviamente anche il plugin per generare le classi SOAP. SI creano gli XSD, poi si lancia: mvn clean generate-sources. Si crea il file di configurazione WebServiceConfig.java che permette di creare i WSDL a runtime. Infine, si realizzano gli endpoint con i servizi implementati.

### REST
Per il front-end + test con Postman. 

### Implementazione
Nello sviluppo si è seguito il pattern MVC: model, repository, dto, mapper, interfaccia service, service e rest controller.


#### Riferimenti
- <a href="https://www.youtube.com/watch?v=Kq-DRboTVrc">Spring Boot</a>
- <a href="https://fullstackopen.com/en/">React</a> 
- <a href="https://www.youtube.com/watch?v=oeni_9g7too&t=333s">Spring Security</a>
- <a href="https://cs50.harvard.edu/sql/2024/">SQL</a>