package br.gms.wssispoker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="jogador")
@XmlRootElement(name="jogador")
@NamedQuery(name="findAllJogador", query="SELECT j FROM Jogador j")
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="jogador", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Entrada> entradas;
	
	@OneToMany(mappedBy="jogador", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Saida> saidas;
	
	@Transient
	private Integer total;
	
	public Jogador(){
		
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the id
	 */
	@XmlElement(name = "id")	
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	//@XmlElement(name = "nome")	
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	//@XmlElement(name = "email")	
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entradas
	 */
	@XmlTransient
	public List<Entrada> getEntradas() {
		return entradas;
	}

	/**
	 * @return the saidas
	 */
	@XmlTransient
	public List<Saida> getSaidas() {
		return saidas;
	}

	/**
	 * @param saidas the saidas to set
	 */
	public void setSaidas(List<Saida> saidas) {
		this.saidas = saidas;
	}

	/**
	 * @param entradas the entradas to set
	 */
	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	
	

}
