package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import app.entity.News;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class NewsModel {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveNews(News entity) {
		
		entityManager.persist(entity);
		
	}

	public List<News> GetNewsList() {
		Query q = entityManager.createQuery("Select n FROM News n");
		List<News> lst = q.getResultList();
		return lst;
	}
	public void DeleteNews(String Id) {
		Query q = entityManager.createQuery("Delete From News n where n.id=" + Id);
		q.executeUpdate();
	}
	public News GetNews(String Id) {
		Query q = entityManager.createQuery("Select n FROM News n where n.id=" + Id);
		List<News> lst =  q.getResultList();
		News ut = lst.getFirst();
		return ut;
	}
	
	public void UpdateUtente(News n) {
		entityManager.merge(n);
	}
	
	
}