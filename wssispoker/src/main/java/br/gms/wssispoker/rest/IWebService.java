package br.gms.wssispoker.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gms.wssispoker.entity.Entrada;
import br.gms.wssispoker.entity.Jogador;
import br.gms.wssispoker.entity.Saida;

@Path("")
public interface IWebService {

	@POST
	@Consumes({MediaType.APPLICATION_XML}) 
	@Produces({MediaType.TEXT_PLAIN})
	@Path("salvarJogador")
	public String salvarJogador(Jogador jogador);
	
	@POST
	@Consumes({MediaType.APPLICATION_XML}) 
	@Produces({MediaType.TEXT_PLAIN})
	@Path("salvarEntrada")
	public String salvarEntrada(Entrada entrada);
	
	@POST
	@Consumes({MediaType.APPLICATION_XML}) 
	@Produces({MediaType.TEXT_PLAIN})
	@Path("salvarSaida")
	public String salvarSaida(Saida saida);
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("obterJogadores")
	public Response listarJogadores();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("TesteWS")
	public Object testarWS();
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("rankingGeral")
	public Response getRankingGeral();
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("rankingByDate")
	public Response getRankingByDate(@QueryParam("data") String data);
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("datasMesas")
	public Response getDatasMesas();
	
	
}
