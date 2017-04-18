package br.com.fiap.beans;

import br.com.fiap.interfaces.Eletronico;

public class Tablet extends Produto implements Eletronico{
	private String modelo;
	private String marca;
	private String sistemaOperacional;
	private boolean tresG;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	public boolean isTresG() {
		return tresG;
	}
	public void setTresG(boolean tresG) {
		this.tresG = tresG;
	}
	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String sistemaOperacional,
			boolean tresG) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sistemaOperacional = sistemaOperacional;
		this.tresG = tresG;
	}
	public Tablet(int codigo, String titulo, double preco) {
		super(codigo, titulo, preco);
	}
	
	@Override
	public double calcularGarantiaEstendida() {
		return getPreco()*0.05;
	}
}
