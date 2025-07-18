package it.registro.scuola.soap;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import it.registro.scuola.service.impl.ScuolaServiceImpl;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.mapper.SoapScuolaMapper;
import it.registro.scuola.model.soap.*;

@Endpoint
public class ScuolaEndpoint {
	// Namespace usato nel WSDL e nello XSD per identificare il servizio 
	private static final String NAMESPACE_URI = "http://scuola.registro.it/scuola";
	
	@Autowired 
	private ScuolaServiceImpl scuolaService;
	
	// Gestisce la richiesta SOAP <getScuolaRequest> per ottenere un impasto per ID
	// @PayloadRoot associa questa richiesta al namespace e al nome dell'elemento XML
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getScuolaRequest")
	// @ResponsePayload indica che il metodo restituisce il payload della risposta SOAP
	@ResponsePayload
	public GetScuolaResponse getScuola(@RequestPayload GetScuolaRequest req) {
		GetScuolaResponse res = new GetScuolaResponse();
		ScuolaDTO s = scuolaService.getScuolaDTO(req.getId());
		res.setScuola(SoapScuolaMapper.toSoap(s));
		return res;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getScuoleRequest")
	@ResponsePayload
	public GetScuoleResponse getScuole(@RequestPayload GetScuoleRequest req) {
		GetScuoleResponse res = new GetScuoleResponse();
		List<ScuolaDTO> scuole = scuolaService.getScuoleDTO();
		for(ScuolaDTO s : scuole) {
			res.getScuola().add(SoapScuolaMapper.toSoap(s));
		}
		return res;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addScuolaRequest")
	@ResponsePayload
	public AddScuolaResponse addScuola(@RequestPayload AddScuolaRequest req) {
		AddScuolaResponse res = new AddScuolaResponse();
		ScuolaDTO s = scuolaService.addScuolaDTO(SoapScuolaMapper.toDTO(req.getScuola()));
		res.setScuola(SoapScuolaMapper.toSoap(s));
		return res;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateScuolaRequest")
	@ResponsePayload
	public UpdateScuolaResponse updateScuola(@RequestPayload UpdateScuolaRequest req) {
		UpdateScuolaResponse res = new UpdateScuolaResponse();
		res.setScuola(SoapScuolaMapper.toSoapUp(scuolaService.updateScuolaDTO(SoapScuolaMapper.toDTOfromUp(req.getScuola()))));
		return res;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteScuolaRequest")
	@ResponsePayload
	public DeleteScuolaResponse deleteScuola(@RequestPayload DeleteScuolaRequest req) {
		DeleteScuolaResponse res = new DeleteScuolaResponse();
		res.setCancellato(scuolaService.deleteScuola(req.getId()));
		return res;
	}
		
}
