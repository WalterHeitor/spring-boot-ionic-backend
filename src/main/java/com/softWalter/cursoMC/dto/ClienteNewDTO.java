package com.softWalter.cursoMC.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.softWalter.cursoMC.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Length(min=5, max= 120, message="O tamanho deve ser ente 5 e "
			+ "120 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Email(message = "Email invalido.")
	private String email;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	private String cpfOuCnpj;
	private Integer tipo;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	private String logadouro;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	private String cep;
	
	@NotEmpty(message = "Preenchimento Obrigatório.")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {
		
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String teleforne1) {
		this.telefone1 = teleforne1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String teleforne2) {
		this.telefone2 = teleforne2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String teleforne3) {
		this.telefone3 = teleforne3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
	
}
