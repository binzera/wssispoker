package br.gms.sispoker.wssispoker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jogadores")
public class JogadorList {
	
	
	private List<Jogador> listaJogadores = new ArrayList<Jogador>();

	/**
	 * @return the listaJogadores
	 */
	@XmlElement(name="jogador")
	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	/**
	 * @param listaJogadores the listaJogadores to set
	 */
	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
	
	
	

}
