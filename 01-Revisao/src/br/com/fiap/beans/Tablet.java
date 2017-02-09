package br.com.fiap.beans;

public class Tablet extends Produto implements Eletronico{
	private String modelo;
	private String marca;
	private String sO;
	private boolean tresG;
	
	public Tablet() {
		super();
	}
	
	public Tablet(String modelo, String marca, String sO, boolean tresG) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.sO = sO;
		this.tresG = tresG;
	}
	
	public Tablet(int codigo, String titulo, double preco, String modelo,
			String marca, String sO, boolean tresG) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sO = sO;
		this.tresG = tresG;
	}

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
	public String getsO() {
		return sO;
	}
	public void setsO(String sO) {
		this.sO = sO;
	}
	public boolean isTresG() {
		return tresG;
	}
	public void setTresG(boolean tresG) {
		this.tresG = tresG;
	}
	
	@Override
	public double calcularGarantia() {
		// TODO Auto-generated method stub
		return this.getPreco() * 0.05;
	}
}
