package com.casa_do_codigo.cliente;

public class NovoClienteResponse {
	

	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private String telefone;
	private String cep;
	

	public NovoClienteResponse(ClienteModel cliente) {

		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
	}


	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getCep() {
		return cep;
	}
	


}