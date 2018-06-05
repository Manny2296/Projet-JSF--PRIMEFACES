package com.ejb.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Couleur;
import model.Finition;
import model.Jante;
import model.Modele;
import model.Motorisation;
import model.Optionsupp;
import model.Voiture;
@Entity
@Stateless
public class VoitureBean implements SessionBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "SR03PROJECT_JPA")
	EntityManager em;

	public VoitureBean() {
	}

	@Override
	public void updateVoiture(Voiture v) {
		em.merge(v);

	}

	public void deleteVoiture(Voiture v) {
		em.remove(v);
	}

	public void addVoiture(Voiture v) {
		em.persist(v);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getVoitures() {
		Query q = em.createQuery("select v from Voiture v");
		//TypedQuery<Voiture> q =  em.createQuery("select v.idvoiture, v.price,v.finitions from Voiture v", Voiture.class);
		System.out.println("size" +q.getResultList().size());
		System.out.println("To string" +q.getResultList().toString());
		List<Voiture> result = q.getResultList();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Couleur> getCouleur() {
		Query q = em.createQuery("select c from Couleur c");
		System.out.println("To string " +q.getResultList().toString());
		List<Couleur> resp =  q.getResultList();
	    return resp;
	}

	@Override
	public List<Modele> getVoitureByID(int id) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT m  FROM Modele m JOIN m.voiture v"
				+ " WHERE v.idvoiture =:id");
		q.setParameter("id", id);
		//TypedQuery<Voiture> q =  em.createQuery("select v.idvoiture, v.price,v.finitions from Voiture v", Voiture.class);
		System.out.println("size" +q.getResultList().size());
		System.out.println("To string" +q.getResultList().toString());
		List<Modele> result = q.getResultList();
		return result;
	}

	@Override
	public List<Motorisation> getMotorisations() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT m FROM Motorisation m");
		//TypedQuery<Voiture> q =  em.createQuery("select v.idvoiture, v.price,v.finitions from Voiture v", Voiture.class);
		System.out.println("size" +q.getResultList().size());
		System.out.println("To string " +q.getResultList().toString());
		List<Motorisation> result = q.getResultList();
		return result;
		
	}

	@Override
	public List<Jante> getJantes() {
		Query q = em.createQuery("SELECT j FROM Jante j");
		//TypedQuery<Voiture> q =  em.createQuery("select v.idvoiture, v.price,v.finitions from Voiture v", Voiture.class);
		System.out.println("size" +q.getResultList().size());
		System.out.println("To string " +q.getResultList().toString());
		List<Jante> result = q.getResultList();
		return result;
	}

	// ANTOINE

		/* marche pas : SELECT c FROM Couleur c : lazy exception
		public List<Couleur> getCouleurs2() {
			Query q = em.createQuery("SELECT c FROM Couleur c");
			List<Couleur> result = q.getResultList();
			return result;
		}
		*/
		
		public List<Modele> getModeles() {
			Query q = em.createQuery("SELECT m FROM Modele m");
		    return q.getResultList();
		}
		public List<Motorisation> getMotorisationByModele(int idmodele) {
			Query q = em.createQuery("SELECT m FROM Motorisation m JOIN m.relmotorisationmodeles relmo JOIN relmo.modele mod"
					+ " WHERE mod.id=:idmodele");
	 		q.setParameter("idmodele", idmodele);
		    return q.getResultList();
		}
		public List<Finition> getFinitions() {
			Query q = em.createQuery("SELECT f FROM Finition f");
		    return q.getResultList();
		}
		
		public List<Optionsupp> getOptionsupp() {
			Query q = em.createQuery("SELECT o FROM Optionsupp o");
		    return q.getResultList();
		}

	
		
		/*public List<Relfinitionmotorisation> getRelfinitionmotorisation() {
			Query q = em.createQuery("SELECT r.idrel FROM Relfinitionmotorisation r");
		    return q.getResultList();
		}
		
		public List<Relfinitionmotorisation> getMotorisationsByFinitions(int idfinition) {
			Query q = em.createQuery("SELECT m.idmotorisation,m.nom,m.prix "
	   				+ "FROM Motorisation m "
	   				+ "JOIN m.relfinitionmotorisations rlm "
	   				+ "JOIN rlm.finition f "
	   				+ "WHERE f.idfinition=:idfinition");
	   		q.setParameter("idfinition", idfinition);
	   		return q.getResultList();
		}*/
	
	
	
	

	
}
