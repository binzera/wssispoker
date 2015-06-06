package br.gms.wssispoker.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.gms.wssispoker.entity.Entrada;
import br.gms.wssispoker.entity.EntradaList;
import br.gms.wssispoker.entity.Jogador;
import br.gms.wssispoker.entity.JogadorList;
import br.gms.wssispoker.entity.Saida;
import br.gms.wssispoker.message.SispokerMessage;
import br.gms.wssispoker.persistence.EntradaDAO;
import br.gms.wssispoker.persistence.JogadorDAO;
import br.gms.wssispoker.persistence.SaidaDAO;
import br.gms.wssispoker.util.JAXBUtil;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;


public class WebService implements IWebService {
	
	@Inject
	private JogadorDAO jogadorDAO;
	
	@Inject
	private EntradaDAO entradaDAO;
	
	@Inject
	private SaidaDAO saidaDAO;
	
	
	public WebService(){
		
	}

	@Override
	@LoggedIn
	public String salvarJogador(Jogador jogador) {
		String retorno = "Não foi possivel salvar o jogador.";
		if(jogador != null){
			if(jogador.getEmail() == null || jogador.getEmail().equals("") 
					|| jogador.getNome() == null || jogador.getEmail().equals("")){
				retorno = "Não é possivel salvar um jgoador sem um email ou nome";
			} else {
				try {
					Jogador jogadorBase = jogadorDAO.getJogadorByEmail(jogador);
					if(jogadorBase != null){
						retorno = "O jogador já cadastrado.";
					} else {
						jogadorDAO.salvar(jogador);
						retorno ="Jogador cadastrado com sucesso";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
		
		return retorno;
	}

	@Override
	public Object testarWS() {
		Jogador jogador = new Jogador();
		jogador.setNome("Binzera");
		jogador.setEmail("EMail");
		jogador.setId(1);
		
		return jogador;
	}

	@Override
	@LoggedIn
	public Response listarJogadores() {
		JogadorList lista = new JogadorList();
		lista.setListaJogadores(jogadorDAO.getAll(Jogador.class));
		
		return JAXBUtil.getTransformResponse(lista);
	}
	
	
	@Override
	@LoggedIn
	public String salvarEntrada(Entrada entrada) {
		String retorno = "Não foi possivel salvar a entrada.";
		if(entrada != null){
			if(entrada.getValor() == null || entrada.getValor().equals("")){
				retorno = "Nao foi possivel salvar uma entrada sem valor";
			} else {
				try {	
					entradaDAO.salvar(entrada);
					retorno ="Entrada cadastrada com sucesso";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}
	
	@Override
	@LoggedIn
	public String salvarSaida(Saida saida) {
		String retorno = "Não foi possivel salvar a saida.";
		if(saida != null){
			if(saida.getValor() == null || saida.getValor().equals("")){
				retorno = "Não é possivel salvar uma saida sem valor";
			} else {
				try {	
					saidaDAO.salvar(saida);
					retorno ="Saida cadastrada com sucesso";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}

	@Override
	public Response getRankingGeral() {
		List<Jogador> jogadores = jogadorDAO.getAll(Jogador.class);
		for (Jogador jogador : jogadores){
			calcaularSaldo(jogador);
		}
		
		Collections.sort(jogadores);
		
		JogadorList lista = new JogadorList();
		lista.setListaJogadores(jogadores);
		
		return JAXBUtil.getTransformResponse(lista);
	}

	private void calcaularSaldo(Jogador jogador) {
		Integer totalEntradas = 0;
		Integer totalSaidas = 0;
		for(Entrada entrada : jogador.getEntradas()){
			totalEntradas += entrada.getValor();
		}
		for (Saida saida : jogador.getSaidas()){
			totalSaidas += saida.getValor();
		}
		
		jogador.setTotal(totalSaidas - totalEntradas);
	}

	@Override
	public Response getRankingByDate(String dataString) {
		Integer totalEntradas = 0;
		Integer totalSaidas = 0;
		List<Jogador> jogadores = jogadorDAO.getAll(Jogador.class);
		List<Jogador> listaRetorno = new ArrayList<Jogador>();

		Date data;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			data = formatter.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
			return JAXBUtil.getTransformResponse(new SispokerMessage(
					"Erro ao converter a data"));
		}

		for (Jogador jogador : jogadores) {
			for (Entrada entrada : jogador.getEntradas()) {
				if (entrada.getData().compareTo(data) == 0) {
					totalEntradas += entrada.getValor();
				}
			}
			for (Saida saida : jogador.getSaidas()) {
				if (saida.getData().compareTo(data) == 0) {
					totalSaidas += saida.getValor();
				}
			}
			jogador.setTotal(totalSaidas - totalEntradas);

			if (jogador.getTotal() != 0) {
				listaRetorno.add(jogador);
			}
			totalEntradas = 0;
			totalSaidas = 0;
		}
		
		Collections.sort(jogadores);
		
		JogadorList lista = new JogadorList();
		lista.setListaJogadores(jogadores);

		return JAXBUtil.getTransformResponse(lista);
		
	}

	@Override
	public Response getDatasMesas() {
		List<Entrada> lista = entradaDAO.getDatasMesas();
		for (Entrada ent : lista) {
			ent.setJogador(null);
			ent.setId(null);
			ent.setValor(null);
		}
		EntradaList entradas = new EntradaList();
		entradas.setListaEntrada(lista);
		return JAXBUtil.getTransformResponse(entradas);
	}
	
	
}
