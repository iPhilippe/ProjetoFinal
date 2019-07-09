package br.com.senac.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	//classe modelo
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "usuario_id")
	private Integer id; 
	
	@Column(name = "usuario_nome")
	private String nome;
	
	@Column(name = "usuario_sobrenome")
	private String sobrenome;
	
	@Column(name = "usuario_usuario")
	private String apelido;
			
	@Column(name = "usuario_telefone")
	private String telefone;
	
	@Column(name = "usuario_senha")
	private String senha;
	
	@Column(name = "usuario_status")
	private String status;	
			
	@JsonIgnore //Anotação para evitar exceção "Recursão Infinita"
	@OneToOne(mappedBy = "Usuario")
	private OrdemServico ordemservico;
	
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public OrdemServico getOrdemservico() {
		return ordemservico;
	}
	public void setOrdemservico(OrdemServico ordemservico) {
		this.ordemservico = ordemservico;
	}
	
	
}

