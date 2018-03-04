package org.bet.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bet.app.entities.FootballMatchEntity;
import org.bet.app.entities.OddsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FootballMatchDAO {

	private static final Logger betLogger = LoggerFactory.getLogger(FootballMatchDAO.class);

	private FootballMatchDAO() {
	};

	public void add(FootballMatchEntity match) {
		EntityManager em = StatsDAO.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			// mettre à jour ici
			// em.persist(OddsEntity);
			tx.commit();

		} catch (Exception e) {
			betLogger.error("Erreur lors de l'ajout dans la table odds.");
			betLogger.error("Erreur : {} {}", e.getMessage(), e.getClass().toString());
			betLogger.error("Rollback de l'insert.");
			tx.rollback();
		} finally {
			em.close();
		}

	}

}
