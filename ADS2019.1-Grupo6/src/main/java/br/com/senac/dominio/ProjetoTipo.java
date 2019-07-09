package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projeto_tipo")
public class ProjetoTipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5159620781630472988L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "projeto_tipo_id")
	private Integer id; 
	
	
	@Column(name = "projeto_tipo_descricao")
	private String descricao;
	
	@Column(name = "projeto_tipo_status")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
