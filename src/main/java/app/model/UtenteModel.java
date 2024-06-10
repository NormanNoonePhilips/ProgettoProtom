package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import app.entity.Utente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class UtenteModel {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveUtente(Utente entity) {
		
		entityManager.persist(entity);
		
	}

	public List<Utente> GetUtenteList() {
		Query q = entityManager.createQuery("Select u FROM Utente u");
		List<Utente> lst = q.getResultList();
		return lst;
	}
	public void DeleteUtente(String Id) {
		Query q = entityManager.createQuery("Delete From Utente u where u.id=" + Id);
		q.executeUpdate();
	}
	public Utente GetUtente(String Id) {
		Query q = entityManager.createQuery("Select u FROM Utente u where u.id=" + Id);
		List<Utente> lst =  q.getResultList();
		Utente ut = lst.get(0);
		return ut;
	}
	
	public void UpdateUtente(Utente u) {
		entityManager.merge(u);
	}
	
	
}