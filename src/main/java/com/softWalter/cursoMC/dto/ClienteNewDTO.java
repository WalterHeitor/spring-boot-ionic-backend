package com.softWalter.cursoMC.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private String CpfouCnpj;
	private Integer tipo;
	
	private String logadouro;
	private String complemento;
	private String bairro;
	private String cep;
	
	private String teleforne1;
	private String teleforne2;
	private String teleforne3;
	
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

	public String getCpfouCnpj() {
		return CpfouCnpj;
	}

	public void setCpfouCnpj(String cpfouCnpj) {
		CpfouCnpj = cpfouCnpj;
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

	public String getTeleforne1() {
		return teleforne1;
	}

	public void setTeleforne1(String teleforne1) {
		this.teleforne1 = teleforne1;
	}

	public String getTeleforne2() {
		return teleforne2;
	}

	public void setTeleforne2(String teleforne2) {
		this.teleforne2 = teleforne2;
	}

	public String getTeleforne3() {
		return teleforne3;
	}

	public void setTeleforne3(String teleforne3) {
		this.teleforne3 = teleforne3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
	
}
