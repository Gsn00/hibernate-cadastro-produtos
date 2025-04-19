package dev.gabrielnovais.dao;

import java.util.List;

import jakarta.persistence.EntityManager;

public class GenericDAO<T, K> {
	
	protected EntityManager em;
	private Class<T> theClass;
	
	public GenericDAO(EntityManager em, Class<T> theClass) {
		this.em = em;
		this.theClass = theClass;
	}
	
	public void insert(T object) {
		em.getTransaction().begin();
			
		em.persist(object);
			
		em.getTransaction().commit();
	}
	
	public T find(K id) {
		return em.find(theClass, id);
	}
	
	public List<T> findAll() {
		return em.createQuery("from " + theClass.getName(), theClass).getResultList();
	}
	
	public T update(T obj) {
		em.getTransaction().begin();
		
		obj = em.merge(obj);
		
		em.getTransaction().commit();
		
		return obj;
	}
	
	public void remove(T obj) {
		em.getTransaction().begin();
		
		em.remove(obj);
		
		em.getTransaction().commit();	
	}

}
