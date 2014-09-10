package br.gms.wssispoker.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.gms.wssispoker.entity.Saida;

public class SaidaDAO extends GenericDAO<Saida> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Saida> getSaidaByDate(Date data){
		List<Saida> retorno;
		
		try{
			Query query = getEntityManager()
					.createQuery(
							"SELECT e FROM Saida e WHERE data = :data",
							Saida.class);
			query.setParameter("data", data);
			retorno = (List<Saida>) query.getResultList();
	
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}

}
