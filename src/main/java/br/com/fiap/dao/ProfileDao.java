package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Profile;
import br.com.fiap.utils.JPAUtil;

public class ProfileDao {

	public void save(Profile profile) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Profile> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT s FROM Profile s";
		TypedQuery<Profile> query = manager.createQuery(jpql, Profile.class);
		// TODO manager.close();

		return query.getResultList();
	}
}