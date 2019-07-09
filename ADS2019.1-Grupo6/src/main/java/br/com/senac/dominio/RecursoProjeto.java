package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="recurso_projeto")
public class RecursoProjeto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4350047715676864158L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "recurso_projeto_id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "recurso_armazen_id")
	private RecursoArmazen recursoArmazen;
	
	
}
