package com.br.Cadastro_Lol.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Campeao")
public class Campeao {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="campeao_seq", sequenceName="campeao_seq", initialValue=4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campeao_seq")
	private Long id;

	@Column(nullable = false, length = 60)
	@NotNull(message = "O Nome é uma informação obrigatória.")
	private String nome;

	@Column(nullable = false, length = 60)
	@NotNull(message = "AD/AP é uma informação obrigatória.")
	private String poder;

	@Column(nullable = false, length = 60)
	@NotNull(message = "Dificuldade é uma informação obrigatória.")
	private String dificuldade;

	@Column(nullable = false, length = 60)
	@NotNull(message = "O Local é uma informação obrigatória.")
	private String local;

	@ManyToOne
	@JoinColumn(name="TipoCampeao")
	 TipoCampeao TipoCampeao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public TipoCampeao getTipoCampeao() {
		return TipoCampeao;
	}

	public void setTipoCampeao(TipoCampeao tipoCampeao) {
		TipoCampeao = tipoCampeao;
	}
	
	

}
