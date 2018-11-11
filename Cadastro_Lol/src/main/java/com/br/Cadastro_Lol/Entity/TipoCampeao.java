package com.br.Cadastro_Lol.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TipoCampeao")
public class TipoCampeao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TipoCampeaoSeq",sequenceName="TipoCampeaoSeq",initialValue=4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoCampeaoSeq")
	private Long id;

	@Column(nullable = false, length = 60)
	@NotNull(message = "Tipo de Campeão é uma informação obrigatória.")
	private String tipo_campeao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_campeao() {
		return tipo_campeao;
	}

	public void setTipo_campeao(String tipo_campeao) {
		this.tipo_campeao = tipo_campeao;
	}

}
