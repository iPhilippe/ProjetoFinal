package br.com.senac.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "registro_trajeto_equipamento")
public class RegistroTrajetoEquipamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "regitro_trajeto_id")
	private RegistroTrajeto registroTrajeto;
	@Column(name = "registro_trajeto_equipamento_quantidade")
	private String quantidade;
	@OneToOne
	@JoinColumn(name = "equipamento_id")
	private Equipamento equipamento;

	public RegistroTrajeto getRegistroTrajeto() {
		return registroTrajeto;
	}

	public void setRegistroTrajeto(RegistroTrajeto registroTrajeto) {
		this.registroTrajeto = registroTrajeto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
