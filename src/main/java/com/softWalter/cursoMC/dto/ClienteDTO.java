package com.softWalter.cursoMC.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.softWalter.cursoMC.domain.Cliente;
import com.softWalter.cursoMC.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Length(min=5, max= 120, message="O tamanho deve ser ente 5 e "
			+ "120 caracteres.")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Email(message = "Email invalido.")
	private String email;
	public ClienteDTO() {
		super();
		
	}
	public ClienteDTO(Cliente obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
