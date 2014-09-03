package br.gms.sispoker.wssispoker.persistencia;

import javax.persistence.Query;

import br.gms.sispoker.wssispoker.entity.Jogador;

public class JogadorDAO extends GenericDAO<Jogador> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Jogador getJogadorByEmail(Jogador jogador){
		Jogador retorno;
		
		try{
			Query query = em
					.createQuery(
							"SELECT j FROM Jogador j WHERE email = :email",
							Jogador.class);
			query.setParameter("email", jogador.getEmail());
			retorno = (Jogador) query.getSingleResult();
	
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}

}
