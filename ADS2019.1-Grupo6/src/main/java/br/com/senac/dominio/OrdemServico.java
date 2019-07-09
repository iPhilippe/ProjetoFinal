package br.com.senac.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_id")
	private Integer id;
	
	@Column(name = "ordem_servico_descricao", length = 300)
	private String descricao;
	
	@Column(name = "ordem_servico_local")
	private String local;
	
	@Column(name = "ordem_servico_data_inicio")
	private String dataDeAbertura;

	@Column(name = "ordem_servico_data_fim")
	private String dataDeFechamento;
	
	@Column(name = "ordem_servico_contratado")
	private String contratista;
	
	@Column(name = "ordem_servico_status")
	private String status;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@JsonIgnore 
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario Usuario;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<RegistroTrajeto> registro_trajeto = new HashSet<>();
	

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(String dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public String getDataDeFechamento() {
		return dataDeFechamento;
	}

	public void setDataDeFechamento(String dataDeFechamento) {
		this.dataDeFechamento = dataDeFechamento;
	}

	public String getContratista() {
		return contratista;
	}

	public void setContratista(String contratista) {
		this.contratista = contratista;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getUsuario() {		
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}



}
