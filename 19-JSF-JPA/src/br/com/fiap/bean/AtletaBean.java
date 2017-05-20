package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;
import br.com.fiap.exception.DBException;
import br.com.fiap.util.BundleUtil;

@ManagedBean
public class AtletaBean {

	private Atleta atleta;

	private AtletaBO bo;
	
	@PostConstruct
	private void init(){
		atleta = new Atleta();
		atleta.setDataNascimento(Calendar.getInstance());
		bo = new AtletaBO();
	}
	
	//M�todo para valida��o customizada do nome
	public void validarNome(FacesContext context, UIComponent 
			component, Object value) throws ValidatorException{
		//recupera o valor que ser� validado
		String nome = value.toString();
		//validar se o nome � composto
		if (!nome.trim().contains(" ")){
			throw new ValidatorException(
				new FacesMessage("O nome deve ser completo"));
		}
	}
	
	public String cadastrar(){
		FacesMessage msg;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (atleta.getCodigo() == 0){
				bo.cadastrar(atleta);
				String mensagem = BundleUtil.getMessageResourceString(context.getApplication().getMessageBundle(), "msg_add_success", null, context.getViewRoot().getLocale());
				msg = new FacesMessage(mensagem);
			}else{
				bo.atualizar(atleta);
				String mensagem = BundleUtil.getMessageResourceString(context.getApplication().getMessageBundle(), "msg_edit_success", null, context.getViewRoot().getLocale());
				msg = new FacesMessage(mensagem);				
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "atleta";
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem ap�s um redirect
		FacesContext.getCurrentInstance().getExternalContext()
								.getFlash().setKeepMessages(true);
		return "lista-atleta?faces-redirect=true";
	}
	
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
}
