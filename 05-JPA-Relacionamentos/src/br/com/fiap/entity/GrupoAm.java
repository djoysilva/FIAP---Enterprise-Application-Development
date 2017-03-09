package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqGrupoAm", sequenceName = "SEQ_TB_GRUPO_AM", allocationSize = 1)

public class GrupoAm {
	@Id
	@GeneratedValue(generator = "seqGrupoAm", strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_GRUPO", nullable = false)
	private int codigo;
	
	@Column(name = "NM_GRUPO", nullable = false)
	private int numero;
	
	public GrupoAm(int codigo, int numero) {
		super();
		this.codigo = codigo;
		this.numero = numero;
	}
	
	public GrupoAm() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
		
}
