package config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Configuration {
	public static String jpa_unit_name = "ProjetJPA";
	public static EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(jpa_unit_name).createEntityManager();
			return entityManager;
		}
		return entityManager;
	}
}
