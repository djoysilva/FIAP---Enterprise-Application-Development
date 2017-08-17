package br.com.fiap.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	
	private ClienteBO bo;
	
	@PostConstruct
	private void init(){
		//Inicializando os objetos
		cliente = new Cliente();
		cliente.setDataNascimento(Calendar.getInstance());
		bo = new ClienteBO();
	}
	/*
	 * criar upload de fotos:
	 * 1 - cria um atributo foto String na entidade Cliente - para guardar o nome da foto
	 * 2 - cria um metodo no cliente Bean
	 * 3 - implementa no xhtml
	 */
	
	/*
	 * exibir fotos:
	 * 1 - cria um metodo no cliente Bean
	 * 2 - cria um metodo no cliente Bean
	 * 3 - implementa no xhtml
	 */
	
	public void subir(FileUploadEvent event){
		try{
			//recuperar o nome do arquivo
			String nome = event.getFile().getFileName();
			//cria o arquivo
			File file = new File("C:\\arquivos\\", nome);	
			//escreve o conteudo do arquivo
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(event.getFile().getContents());
			stream.close();
			//coloca nome do arquivo no cliente
			cliente.setFoto(nome);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StreamedContent getFoto(){
		
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		try{	
			if(FacesContext.getCurrentInstance().getRenderResponse() ||
					cliente.getFoto() == null){
				content.setStream(new FileInputStream("C:\\arquivos\\foto.jpg"));
			}else{
				content.setStream(new FileInputStream("C:\\arquivos\\" + cliente.getFoto()));
			}
		}catch(FileNotFoundException e){
				e.printStackTrace();
		}
		return content;	
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if (cliente.getCodigo() == 0){
				bo.cadastrar(cliente);
				msg = new FacesMessage("Cadastrado!");
			}else{
				bo.atualizar(cliente);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
								.getFlash().setKeepMessages(true);
		return "cliente?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
