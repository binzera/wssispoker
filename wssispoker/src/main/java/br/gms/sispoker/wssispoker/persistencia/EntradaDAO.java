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
	
	@SuppressWarnings("unchecked")
	public List<Entrada> getDatasMesas(){
		List<Entrada> retorno;
				
		try{
			
			String sql = "select t.* from (select *, row_number() over "
					+ "(partition by data order by data) as seqnum from entrada) t where seqnum = 1;";
			
			Query query = em
					.createNativeQuery(sql, Entrada.class);
			retorno = (List<Entrada>) query.getResultList();
	
		} catch (Exception e) {
			retorno = null;
		}

		return retorno;
	}
}
