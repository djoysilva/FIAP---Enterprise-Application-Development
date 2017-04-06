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
	
	private static final String URL = "http://localhost:8080/13-WebserviceRestfull-server-banco/rest/atleta/";
	
	private Client client = new Client();
	
	public List<AtletaTO> listar() throws WebServiceException{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus() != 200){
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
		AtletaTO[] array = response.getEntity(AtletaTO[].class);  
		return Arrays.asList(array);
	}
	
	public AtletaTO buscar(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
		return response.getEntity(AtletaTO.class);
	}
	
	public void cadastrar (AtletaTO atleta) throws WebServiceException{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, atleta);
		if(response.getStatus() != 201){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
	}
	
	public void atualizar(AtletaTO atleta) throws WebServiceException{
		WebResource resource = client.resource(URL + atleta.getCodigo());
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, atleta);
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
	}
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
	}
}
