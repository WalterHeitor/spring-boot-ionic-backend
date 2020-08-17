package com.softWalter.cursoMC.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.softWalter.cursoMC.domain.Categoria;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigátorio.")
	@Length(min = 5, max = 80, message = "Otamanho deve ser entre"
			+ "5 e 80 caracteres")
	private String nome;
	public CategoriaDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CategoriaDTO(Categoria obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
	}
	
}
