package cgm.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class ProductJPA<T> {
	
	protected EntityManager em;
	
	public ProductJPA(){
		em = Persistence.createEntityManagerFactory("MyFirstProject").createEntityManager();
		
	}
	
}
