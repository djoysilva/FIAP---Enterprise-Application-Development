package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;

@ManagedBean
public class ListaAtletaBean {
	private List<Atleta> atletas;

	private AtletaBO bo;
	
	@PostConstruct
	private void init(){
		bo= new AtletaBO();
		atletas = bo.listar();
	}
	
	public String excluir(int codigo){
		FacesMessage msg;
		try{
			bo.remover(codigo);
			msg = new FacesMessage("Excluido!");
		}catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-atleta?faces-redirect=true";
	}
	
	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	
	
}
