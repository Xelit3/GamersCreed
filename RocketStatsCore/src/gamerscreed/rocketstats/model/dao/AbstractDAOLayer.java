package gamerscreed.rocketstats.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAOLayer<T> {

	/** The entity manager. */
	protected EntityManager entityManager;
	
	/** The factory name. */
	private final String FACTORY_NAME = "RocketStats";
	
	/**
	 * Instantiates a new generic DAO layer.
	 */
	public AbstractDAOLayer(){
		EntityManagerFactory tmpEntinyManagerFactory = Persistence.createEntityManagerFactory(FACTORY_NAME);
		this.entityManager = tmpEntinyManagerFactory.createEntityManager();	
	}
		
	/**
	 * Begin transaction.ASasA
	 */
	protected void beginTransaction(){
		if(!entityManager.getTransaction().isActive())
			entityManager.getTransaction().begin();
	}
	
	/**
	 * Commit transaction.
	 */
	protected void finishTransaction(){
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public boolean saveEntity(T anObject){
		try{
			this.beginTransaction();
			this.entityManager.persist(anObject);
			this.finishTransaction();
			return true;
		}
		catch(Exception e){
			entityManager.close();
			return false;
		}
	}
	
	public boolean saveEntities(List<T> anObjectList){
		try{
			this.beginTransaction();
			for(Object iObject : anObjectList){
				this.entityManager.persist(iObject);
			}
			this.finishTransaction();
			return true;
		}
		catch(Exception e){
			entityManager.close();
			return false;
		}
	}
	
	public boolean updateEntity(T anObject){
		try{
			this.beginTransaction();
			this.entityManager.merge(anObject);
			this.finishTransaction();
			return true;
		}
		catch(Exception e){
			entityManager.close();
			return false;
		}
	}
	
	public boolean removeEntity(T anObject){
		try{
			this.beginTransaction();
			this.entityManager.remove(anObject);
			this.finishTransaction();
			return true;			
		}
		catch(Exception e){
			entityManager.close();
			return false;
		}
	}
	
	public abstract T getById(int anId);
}
