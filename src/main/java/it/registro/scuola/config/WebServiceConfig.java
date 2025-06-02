package it.registro.scuola.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Abilita il supporto per i servizi SOAP in Spring Web Services
// Questa annotazione attiva le funzionalità SOAP, permettendo di gestire richieste e risposte SOAP
@EnableWs
// Indica che questa classe è una configurazione Spring
// Contiene definizioni di bean che configurano i servizi SOAP
@Configuration
// Estende WsConfigurerAdapter per personalizzare la configurazione SOAP 
public class WebServiceConfig extends WsConfigurerAdapter {
	
    // Configura il servlet che gestisce tutte le richieste SOAP
    // Questo servlet riceve le richieste HTTP su /soap/* e le instrada agli endpoint SOAP
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        // Crea un'istanza di MessageDispatcherServlet, il componente che gestisce le richieste SOAP
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        // Imposta il contesto dell'applicazione Spring per il servlet
        // Questo permette al servlet di accedere ai bean Spring (es. endpoint)
        servlet.setApplicationContext(applicationContext);
        // Abilita la trasformazione automatica degli URL nei WSDL
        // Sostituisce localhost:8080 con l'host/porta effettivi (es. localhost:8005)
        servlet.setTransformWsdlLocations(true);
        // Registra il servlet per gestire tutte le richieste su /soap/*
        // Es. http://localhost:8005/pizzeria-maven/soap/impasto
        return new ServletRegistrationBean<>(servlet, "/soap/*");
    }

    // Configura il WSDL per il servizio Impasto
    // Il WSDL definisce l'interfaccia del servizio SOAP (operazioni, messaggi, ecc.)
    @Bean(name = "scuola") // Il nome del bean è "scuola", usato per identificare il WSDL
    public DefaultWsdl11Definition scuolaWsdlDefinition(XsdSchema scuolaSchema) {
        // Crea un oggetto che genera un WSDL conforme allo standard WSDL 1.1
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        // Imposta il nome del portType (definito nel WSDL originale)
        wsdl.setPortTypeName("ScuolaServicePortType");
        // Specifica l'URI dove il servizio è accessibile
        // Le richieste SOAP saranno inviate a /soap/scuola
        wsdl.setLocationUri("/soap/scuola");
        // Definisce il namespace del servizio, che deve corrispondere a quello nello XSD/WSDL
        wsdl.setTargetNamespace("http://scuola.registro.it/scuola");
        // Associa lo schema XSD (scuola.xsd) al WSDL
        // Lo XSD definisce la struttura dei dati (es. <scuola>, <getScuolaRequest>)
        wsdl.setSchema(scuolaSchema);
        // Restituisce la configurazione del WSDL, che sarà disponibile su /soap/scuola.wsdl
        return wsdl;
    }

    // Definisce lo schema XSD per il servizio Scuola
    @Bean
    public XsdSchema scuolaSchema() {
        // Crea un oggetto XsdSchema che punta al file scuola.xsd
        // ClassPathResource cerca il file in src/main/resources/xsd/scuola.xsd
        return new SimpleXsdSchema(new ClassPathResource("xsd/scuola.xsd"));
    }

    
}