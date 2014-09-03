package br.gms.sispoker.wssispoker.persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.gms.sispoker.wssispoker.entity.Entrada;

public class EntradaDAO extends GenericDAO<Entrada> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("unchecked")
	public List<Entrada> getEntradaByDate(Date data){
		List<Entrada> retorno;
		
		try{
			Query query = em
					.createQuery(
							"SELECT e FROM Entrada e WHERE data = :data",
							Entrada.class);
			query.setParameter("data", data);
			retorno = (List<Entrada>) query.getResultList();
	
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}

}
