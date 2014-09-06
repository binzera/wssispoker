package br.gms.sispoker.wssispoker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entradas")
public class EntradaList {
	
	private List<Entrada> listaEntrada = new ArrayList<Entrada>();

	/**
	 * @return the listaEntrada
	 */
	@XmlElement(name="entrada")
	public List<Entrada> getListaEntrada() {
		return listaEntrada;
	}

	/**
	 * @param listaEntrada the listaEntrada to set
	 */
	public void setListaEntrada(List<Entrada> listaEntrada) {
		this.listaEntrada = listaEntrada;
	}
	
	

}
