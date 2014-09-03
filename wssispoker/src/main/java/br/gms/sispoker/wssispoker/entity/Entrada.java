package br.gms.sispoker.wssispoker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="entrada")
@XmlRootElement(name="entrada")
public class Entrada {
	
	@Id
	@SequenceGenerator( name = "entrada_id", sequenceName = "sequence_entrada", allocationSize = 1 )  
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "entrada_id" )
	@Column(name="id")
	private Integer id;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="valor")
	private Integer valor;
	
	@ManyToOne
	@JoinColumn(name="jogador_id")
	private Jogador jogador;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@XmlElement(name="id")
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	@XmlElement(name="data")
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the valor
	 */
	@XmlElement(name="valor")
	public Integer getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	/**
	 * @return the jogador
	 */
	public Jogador getJogador() {
		return jogador;
	}

	/**
	 * @param jogador the jogador to set
	 */
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	

}
