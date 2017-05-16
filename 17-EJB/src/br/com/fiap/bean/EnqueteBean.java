package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.EnqueteBO;

@ManagedBean
public class EnqueteBean {
	private int totalE, totalD;
	
	@EJB
	private EnqueteBO bo;
	
	@PostConstruct
	private void init(){
		apurarResultados();
	}
	
	public void votarE(){
		bo.votarEnterprise();
		apurarResultados();
	}
	
	public void votarD(){
		bo.votarDigital();
		apurarResultados();
	}

	private void apurarResultados() {
		totalE = bo.apurarEnterprise();
		totalD = bo.apurarDigital();
		
	}

	public int getTotalE() {
		return totalE;
	}

	public void setTotalE(int totalE) {
		this.totalE = totalE;
	}

	public int getTotalD() {
		return totalD;
	}

	public void setTotalD(int totalD) {
		this.totalD = totalD;
	}

	public EnqueteBO getBo() {
		return bo;
	}

	public void setBo(EnqueteBO bo) {
		this.bo = bo;
	}
	
	

}
