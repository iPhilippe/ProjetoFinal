package br.com.senac.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "registro_trajeto")
public class RegistroTrajeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registro_trajeto_id")
	private Integer id;
	
	@Column(name = "registro_trajeto_lat")
	private Double lat;
	
	@Column(name = "registro_trajeto_long")
	private Double longitude;
	
	@Column(name = "registro_trajeto_ordem")
	private int ordem;
	
	@Column(name = "registro_trajeto_tipo")
	private char trajetotipo;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tipo_trajeto_id")
	private TipoTrajeto tipoTrajeto;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ordem_servico_id")
	private OrdemServico ordemServico;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public char getTrajetotipo() {
		return trajetotipo;
	}

	public void setTrajetotipo(char trajetotipo) {
		this.trajetotipo = trajetotipo;
	}

	public TipoTrajeto getTipoTrajeto() {
		return tipoTrajeto;
	}

	public void setTipoTrajeto(TipoTrajeto tipoTrajeto) {
		this.tipoTrajeto = tipoTrajeto;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
