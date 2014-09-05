package br.gms.sispoker.wssispoker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.gms.sispoker.wssispoker.entity.Entrada;
import br.gms.sispoker.wssispoker.entity.Jogador;
import br.gms.sispoker.wssispoker.entity.JogadorList;
import br.gms.sispoker.wssispoker.entity.Saida;
import br.gms.sispoker.wssispoker.persistencia.EntradaDAO;
import br.gms.sispoker.wssispoker.persistencia.JogadorDAO;
import br.gms.sispoker.wssispoker.persistencia.SaidaDAO;
import br.gms.sispoker.wssispoker.util.JAXBUtil;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class WebService implements IWebService {
	
	@Inject
	private JogadorDAO jogadorDAO;
	
	@Inject
	private EntradaDAO entradaDAO;
	
	@Inject
	private SaidaDAO saidaDAO;

	@Override
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
	public Response testarWS() {
		Jogador jogador = new Jogador();
		jogador.setNome("Binzera");
		jogador.setEmail("EMail");
		jogador.setId(1);
		
		return JAXBUtil.getTransformResponse(jogador);
	}

	@Override
	public Response listarJogadores() {
		JogadorList lista = new JogadorList();
		lista.setListaJogadores(jogadorDAO.getAll(Jogador.class));
		
		return JAXBUtil.getTransformResponse(lista);
	}

	@Override
	public String salvarEntrada(Entrada entrada) {
		String retorno = "Não foi possivel salvar a entrada.";
		if(entrada != null){
			if(entrada.getValor() == null || entrada.getValor().equals("")){
				retorno = "Não é possivel salvar uma entrada sem valor";
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
	public Response getRankingByDate(Date data) {
		Integer totalEntradas = 0;
		Integer totalSaidas = 0;
		List<Jogador> jogadores = jogadorDAO.getAll(Jogador.class);
		List<Jogador> listaRetorno = new ArrayList<Jogador>();
		
		for (Jogador jogador : jogadores){
			for(Entrada entrada : jogador.getEntradas()){
				if(entrada.getData().compareTo(data) == 0){
					totalEntradas += entrada.getValor();
				}
			}
			for (Saida saida : jogador.getSaidas()){
				if(saida.getData().compareTo(data) == 0){
					totalSaidas += saida.getValor();
				}
			}
			jogador.setTotal(totalSaidas - totalEntradas);
			
			if(jogador.getTotal() != 0){
				listaRetorno.add(jogador);
			}
			totalEntradas = 0;
			totalSaidas = 0;
		}
		
		JogadorList lista = new JogadorList();
		lista.setListaJogadores(jogadores);
		
		return JAXBUtil.getTransformResponse(lista);
		
	}

	@Override
	public Response getDatasMesas() {
		List<Entrada> lista = entradaDAO.getDatasMesas();
		return JAXBUtil.getTransformResponse(lista);
	}
	
	
}
