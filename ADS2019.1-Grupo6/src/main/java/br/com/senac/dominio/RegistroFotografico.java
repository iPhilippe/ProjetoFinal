package br.com.senac.dominio;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="registro_fotografico")
public class RegistroFotografico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registro ")
	private int id;
	@Column(name="registro_fototgrafico_descricao")
	private String descricao;
	@Column(name="registro_fotografico_data")
	private Date data;
	@Column(name="registro_fotografico_link_foto")
	private String linkFoto;
	@Column(name="registro_fotografico_lat")
	private Double latitude;
	@Column(name="registro_fotografico_long")
	private Double longitude;
	@OneToOne
	@JoinColumn(name="registro_trajeto_id")
	private RegistroTrajeto registroTrajeto;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public RegistroTrajeto getRegistroTrajeto() {
		return registroTrajeto;
	}
	public void setRegistroTrajeto(RegistroTrajeto registroTrajeto) {
		this.registroTrajeto = registroTrajeto;
	}
	
	
	
}
