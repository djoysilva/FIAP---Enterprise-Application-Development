package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

@ManagedBean
public class AtletaBean {

	private Atleta atleta;
	
	private AtletaRepository rep;
	
	//M�todo de inicializa��o
	@PostConstruct
	public void init(){
		atleta = new Atleta();
		rep = new AtletaRepository();
	}
	
	//M�todo para o clique do bot�o
	public void cadastrar(){
		try {
			rep.cadastrar(atleta);
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
}
