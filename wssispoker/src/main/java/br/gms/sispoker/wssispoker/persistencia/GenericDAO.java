package br.gms.sispoker.wssispoker.persistencia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

public class GenericDAO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "sispoker")
	public EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	public void salvar(T entity) throws Exception {
		try {
			userTransaction.begin();
			em.persist(entity);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar o objeto do tipo: "
					+ entity.getClass().getName());
		}
	}

	public void update(T entity) {
		try {
			em.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove um objeto da base de dados
	 * 
	 * @param entidade
	 */
	public void delete(T entidade) {
		try {
			em.remove(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe){
		List<T> lista = null;
		try {
			//userTransaction.begin();
			lista = em.createQuery("Select o from " + classe.getSimpleName() + " o ").getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}

}
