package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.AtletaTO;

public class AtletaRepository {
	
	private Client client = new Client();
	
	private static final String URL = "http://localhost:8080/13-WebserviceRestfull-server-banco/rest/atleta/";
	
	public List<AtletaTO> listar() throws WebServiceException{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus() != 200){
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
		AtletaTO[] array = response.getEntity(AtletaTO[].class);  
		return Arrays.asList(array);
	}
	
}
