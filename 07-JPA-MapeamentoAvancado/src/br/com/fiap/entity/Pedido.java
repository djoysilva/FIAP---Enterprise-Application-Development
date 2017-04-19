package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="PedidoSeq", sequenceName="SQ_TB_PEDIDO", allocationSize= 1)
@Table(name = "TB_PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PedidoSeq")
	@Column(name = "CD_PEDIDO")
	private int codigo;
	
	@Column(name = "NM_CLIENTE")
	private String nomeCliente;
	
	@Column(name = "DT_PEDIDO")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	
	public Pedido() {
		super();
	}

	public Pedido(int codigo, String nomeCliente, Calendar data) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.data = data;
	}
	
	public Pedido(String nomeCliente, Calendar data) {
		super();
		this.nomeCliente = nomeCliente;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
}
