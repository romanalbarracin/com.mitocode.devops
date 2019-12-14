package com.mitocode.devops.comun;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	private static EntityManagerFactory emf;
	private static final String UNITNAME = "com.mitocode.devops";

	private JPAUtility() {
		// Not objects
	}
	
	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(UNITNAME);
		}
		return emf.createEntityManager();
	}
}
