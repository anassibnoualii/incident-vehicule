package jpa.ficheIncident.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.vehicule.dao.Vehicule;


public class FicheIncidentDaoJpaImpl implements FicheIncidentDao {
	private EntityManager em;
	public FicheIncidentDaoJpaImpl(EntityManager em) {
	this.em = em;
	}
	@Override
	public void insererFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage) {

		EntityTransaction etx = null;
		try {
		// Initialiser une transaction JPA
		etx = this.em.getTransaction();
		etx.begin();
		// Insérer
		this.em.persist(_ficheIncidentVoyage);
		// Commiter la transaction JPA
		etx.commit();
		} catch (Exception e) {
		e.printStackTrace();
		if (etx != null) {
		etx.rollback();
		}
		}
		
	}

	@Override
	public List<FicheIncident> rechercherTousLesFicheIncidentVoyages() {
		// TODO Auto-generated method stub
		String queryString = "select f from FicheIncident f";
		Query query = this.em.createQuery(queryString);
		return query.getResultList();
	}

	@Override
	public FicheIncident rechercherFicheIncidentVoyageParId(Long _id) {
		// TODO Auto-generated method stub
		return this.em.find(FicheIncident.class, _id);
	}

	@Override
	public void modifierFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			
			this.em.merge(_ficheIncidentVoyage);
			etx.commit();
			
			}
		catch(Exception e) {
			e.printStackTrace();
			if(etx!=null) {
				etx.rollback();
			}
		}

	}

	@Override
	public void supprimerFicheIncidentVoyageParId(FicheIncident _ficheIncidentVoyage) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			
			this.em.remove(_ficheIncidentVoyage);
			etx.commit();
			
			}
		catch(Exception e) {
			e.printStackTrace();
			if(etx!=null) {
				etx.rollback();
			}
		}
		
	}
	@Override
	public void supprimerFicheIncidentParId(Long _id) {
		// Chercher le vehicule
		FicheIncident ficheIncident = this.em.find(FicheIncident.class, _id);
		if (ficheIncident != null) {
			EntityTransaction etx = null;
			try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();

				// Supprimer l'entité
				this.em.remove(ficheIncident);

				// Commiter la transaction JPA
				etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
					etx.rollback();
				}
			}
		}

	}
	@Override
	public List<FicheIncident> rechercherIncidentParVehicule(Vehicule _vehicule) {
		String queryString = "select f from FicheIncident f where f.vehicule = :vehi";
		Query query = this.em.createQuery(queryString);
		query.setParameter("vehi", _vehicule);
		return query.getResultList();
	}
	
	@Override
	public List<FicheIncident> rechercherIncidentParImmatriculation(String immatriculation) {
		String queryString = "select f from FicheIncident f where f.vehicule.immatriculation = :imm";
		Query query = this.em.createQuery(queryString);
		query.setParameter("imm", immatriculation);
		return query.getResultList();
	}
	
	
	
	
		
		
	}
	


