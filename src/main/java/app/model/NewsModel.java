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
		News ut = entityManager.find(News.class, Integer.parseInt(Id));
		return ut;
	}
	
	public void UpdateNews(News n) {
		entityManager.merge(n);
	}
	public List<News> MostRecent(){
		  Query q = entityManager.createQuery("Select n FROM News n ORDER BY n.dataPublicazione DESC LIMIT 3");
		  List<News> lst =  q.getResultList();
		  return lst;
		}
	
	
}