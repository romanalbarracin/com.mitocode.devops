package com.mitocode.devops.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mitocode.devops.model.Persona;
import com.mitocode.devops.comun.JPAUtility;

@Path("/services")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ServicePersona {
	private static final Logger LOGGER = Logger.getLogger(ServicePersona.class.getName());
	
	@POST
	@Path("/persona")
	@Consumes({MediaType.APPLICATION_JSON})
	public Persona create(Persona dto) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(dto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			LOGGER.log(Level.SEVERE, "Exception Insert", ex);
		} finally {
			em.close();
		}
		return dto;
	}

	@PUT
	@Path("/persona")
	public Persona update(Persona dto) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(dto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			LOGGER.log(Level.SEVERE, "Exception Update", ex);
		} finally {
			em.close();
		}
		return dto;
	}

	@GET
	@Path("/persona/{id}")
	public Persona find(@PathParam("id") String id) {
		EntityManager em = JPAUtility.getEntityManager();
		Persona persona = new Persona();
		try {
			persona = em.find(Persona.class, Long.parseLong(id));
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Exception Find", ex);
		} finally {
			em.close();
		}
		return persona;
	}
	
	@GET
	@Path("/persona")
	@SuppressWarnings("unchecked")
	public List<Persona> listPersona() {
		EntityManager em = JPAUtility.getEntityManager();
		List<Persona> personas = new ArrayList<>();
		try {
			personas = em.createQuery("SELECT p FROM Persona p").getResultList();
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Exception List", ex);
		} finally {
			em.close();
		}
		return personas;
	}
}
