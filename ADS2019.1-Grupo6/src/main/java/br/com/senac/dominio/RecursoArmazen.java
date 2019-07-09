package br.com.senac.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material_armazen")
public class RecursoArmazen {
	
	@Id
	@Column(name = "material_armazen_id")
	private Integer id;
	
	@Column(name = "material_armazen_nome")
	private String nome;
	
	@Column(name = "material_armazen_tipo")
	private String tipo;
	
	@Column(name = "material_armazen_status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "unidade_medida_id")
	private UnidadeMedida unidadeMedida;
	
	

}
