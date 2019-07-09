package br.com.senac.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "equipamento")
public class Equipamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipamento_id")
	private int id;
	@Column(name = "equipamento_descricao")
	private String descricao;
	@Column(name = "equipamento_status")
	private char status;
	@OneToOne(mappedBy = "equipamento")
	private RegistroTrajetoEquipamento registroTrajetoEquipamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public RegistroTrajetoEquipamento getRegistroTrajetoEquipamento() {
		return registroTrajetoEquipamento;
	}

	public void setRegistroTrajetoEquipamento(RegistroTrajetoEquipamento registroTrajetoEquipamento) {
		this.registroTrajetoEquipamento = registroTrajetoEquipamento;
	}

}
