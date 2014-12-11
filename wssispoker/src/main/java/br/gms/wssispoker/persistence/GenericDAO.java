package br.gms.wssispoker.persistence;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class GenericDAO<T> extends JPACrud<T, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@PersistenceContext(unitName = "sispoker")
//	public EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	public void salvar(T entity) throws Exception {
		try {
			userTransaction.begin();
			getEntityManager().persist(entity);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar o objeto do tipo: "
					+ entity.getClass().getName());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe){
		List<T> lista = null;
		try {
//			userTransaction.begin();
			lista = getEntityManager().createQuery("Select o from " + classe.getSimpleName() + " o ").getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}

}
