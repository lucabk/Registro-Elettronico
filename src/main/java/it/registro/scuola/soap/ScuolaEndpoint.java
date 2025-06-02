package it.registro.scuola.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import it.registro.scuola.model.soap.Scuola;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.soap.*;
import it.registro.scuola.service.ScuolaService;

@Endpoint
public class ScuolaEndpoint {
	// Namespace usato nel WSDL e nello XSD per identificare il servizio 
	private static final String NAMESPACE_URI = "http://scuola.registro.it/scuola";
	
	@Autowired 
	private ScuolaService scuolaService;
	
	// Gestisce la richiesta SOAP <getScuolaRequest> per ottenere un impasto per ID
	// @PayloadRoot associa questa richiesta al namespace e al nome dell'elemento XML
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getScuolaRequest")
	// @ResponsePayload indica che il metodo restituisce il payload della risposta SOAP
	@ResponsePayload
	public GetScuolaResponse getScuola(@RequestPayload GetScuolaRequest req) {
		GetScuolaResponse res = new GetScuolaResponse();
		ScuolaDTO s = scuolaService.getScuolaDTO(req.getId());
		res.setScuola(toSoap(s));
		return res;
	}
	
	
	private Scuola toSoap(ScuolaDTO s) {
		Scuola sSoap = new Scuola();
		sSoap.setId(s.getId());
		sSoap.setNome(s.getNome());
		sSoap.setTipo(s.getTipo());
		sSoap.setIndirizzo(s.getIndirizzo());
		sSoap.setCitta(s.getCitta());
		sSoap.setProvincia(s.getProvincia());
		sSoap.setCap(s.getCap());
		sSoap.setRegione(s.getRegione());
		return sSoap;
	}
}
