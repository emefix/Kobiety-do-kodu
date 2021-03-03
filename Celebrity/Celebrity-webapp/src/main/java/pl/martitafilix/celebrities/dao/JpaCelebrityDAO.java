package pl.martitafilix.celebrities.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.martitafilix.celebrities.domain.Celebrity;

@Component
//@Transactional
//@Service
public class JpaCelebrityDAO implements CelebrityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public JpaCelebrityDAO() {}
	
	/**
	 * Add a celebrity.
	 */
	@Override
	@Transactional(readOnly=false)
	public void addCelebrity(Celebrity c) {
		entityManager.merge(c);
//		entityManager.persist(c);
	}
	/**
	 * Get all celebrities.
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Celebrity> getCelebrities() {
		
		List<Celebrity> celebrities = null;
		try {
			Query query = entityManager.createQuery("SELECT c FROM Celebrity c"); 
			celebrities = query.getResultList();
		} catch (NoResultException e) {
			e.getMessage();
			System.out.println("There isn't any celebrity!");
		}
		return celebrities;
	}
	/**
	 * Get celebrity by id.
	 */
	@Override
	@Transactional(readOnly=true)
	public Celebrity getCelebrityById(Integer id) {
		
//		Query query = entityManager.createQuery("SELECT * FROM celebrities WHERE id = ?", id); 
		Celebrity celebrity = null;
		try {
			celebrity = entityManager.find(Celebrity.class, id);
//			c = query.getSingleResult();
		} catch(NoResultException e) {
			e.getMessage();
			System.out.println("There isn't a celebrity!");
		} catch(NonUniqueResultException e) {
			e.getMessage();
			System.out.println("There are many celebrities!");
			e.printStackTrace();
		}
		return celebrity;
	}
}
