package br.com.db1.pedidos.pedidosapi.domain.dto;


import java.io.Serializable;

import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;

public class ClienteDTO implements Serializable {

	public static final long serialVersionUID = 23L;
			
	private Long id;
	private String nome;
	private String cpf;
	private ClienteStatus status;

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Long id, String nome, String cpf, ClienteStatus status) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public ClienteStatus getStatus() {
		return status;
	}

	public void setStatus(ClienteStatus status) {
		this.status = status;
	}

	public ClienteDTO(String nome, String cpf) {
		this.nome = nome;
		this.nome = cpf;
	}
	

	
	
}
