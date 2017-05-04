package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImcBean {

	private float peso;
	
	private float altura;
	
	private float imc;
	
	//M�todo para o clique do bot�o
	public void calcular(){
		setImc(peso/(altura*altura));
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}
	
}
