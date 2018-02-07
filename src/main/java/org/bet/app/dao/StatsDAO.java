package org.bet.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.bet.app.entities.StatsEntity;
import org.springframework.stereotype.Component;

@Component
public class StatsDAO {

	private static final Logger betLogger = Logger.getLogger(StatsDAO.class);

	public static EntityManager getEntityManager(){
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		return  emf.createEntityManager();
	}
	
	
	public void add() {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			StatsEntity testEntity = new StatsEntity();

			em.persist(testEntity);
			tx.commit();
		} catch (Exception e) {
			betLogger.error("cannot commit transaction", e);
			tx.rollback();
		} finally {
			em.close();
		}
		em.getEntityManagerFactory().close();
	}
}
