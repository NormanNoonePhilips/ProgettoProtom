package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import app.entity.Admin;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Stateless
public class AdminModel {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveAdmin(Admin entity) {
		
		entityManager.persist(entity);
		
	}

	public List<Admin> GetAdminList() {
		Query q = entityManager.createQuery("Select u FROM Admin u");
		List<Admin> lst = q.getResultList();
		return lst;
	}
	
	public void DeleteAdmin(String Id) {
		Query q = entityManager.createQuery("Delete From Admin u where u.id=" + Id);
		q.executeUpdate();
	}
	
	public Admin GetAdmin(String Id) {
		Query q = entityManager.createQuery("Select u FROM Admin u where u.id=" + Id);
		List<Admin> lst =  q.getResultList();
		Admin ad = lst.get(0);
		return ad;
	}
	
	public boolean LoginAdmin(String username, String password) {
		boolean flag=false;
		Query q = entityManager.createQuery("Select u FROM Admin u where u.username=" + username + "&& u.password =" + password);
		List<Admin> lst = q.getResultList();
		flag = !lst.isEmpty();
		return flag;
	}
	
	public void UpdateAdmin(Admin u) {
		entityManager.merge(u);
	}
	
	
}