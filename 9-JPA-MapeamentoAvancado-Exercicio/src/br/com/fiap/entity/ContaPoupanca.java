package br.com.fiap.entity;

import javax.persistence.Column;

public class ContaPoupanca extends Conta{
	
	@Column(name="VL_RENDIMENTO", nullable=false)
	private double rendimento;

	public ContaPoupanca(double rendimento) {
		super();
		this.rendimento = rendimento;
	}

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int numero, Agencia agencia, double saldo, double rendimento) {
		super(numero, agencia, saldo);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
		
}
