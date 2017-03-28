package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_TIME")
@SequenceGenerator(name="seqTime", sequenceName="SQ_TB_TIME", allocationSize=1)
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqTime")
	@Column(name="CD_TIME", nullable=false)
	private int codigo;
	
	@Column(name="NM_TIME")
	private String nome;
	
	@Column(name="DT_FUNDACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataFundacao;
	
	@Column(name="NR_TITULO")
	private int titulo;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_TECNICO")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy = "time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TB_TIME_CAMPEONATO", joinColumns=@JoinColumn(name="CD_TIME"),
	inverseJoinColumns=@JoinColumn(name="CD_TIME"))
	private List<Campeonato> campeonatos;
	
	public void addJogador(Jogador jogador){
		jogadores.add(jogador);
		jogador.setTime(this);
	}
	
	public Time(int codigo, String nome, Calendar dataFundacao, int titulo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
		this.titulo = titulo;
	}

	public Time() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
}
