package org.bet.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bet.app.entities.OddsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OddsDAO {

	private static final Logger betLogger = LoggerFactory.getLogger(OddsDAO.class);
	
	private OddsDAO(){};
	
	public void add(OddsEntity oddsEntity){
		EntityManager em = StatsDAO.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try{
			
			em.persist(oddsEntity);
			tx.commit();
			
		} catch (Exception e){
			betLogger.error("Erreur lors de l'ajout dans la table odds.");
			betLogger.error("Erreur : {} {}",e.getMessage(),e.getClass().toString());
			betLogger.error("Rollback de l'insert.");
			tx.rollback();
		} 
		finally {
			em.close();
		}
		
	}
}
