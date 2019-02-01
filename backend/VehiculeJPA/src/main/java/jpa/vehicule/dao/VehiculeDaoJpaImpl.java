package jpa.vehicule.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class VehiculeDaoJpaImpl implements VehiculeDao {

	private EntityManager em;

	public VehiculeDaoJpaImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation) {

		EntityTransaction etx = null;
		try {
			// Initialiser une transaction JPA
			etx = this.em.getTransaction();
			etx.begin();

			// Construire l'objet Vehicule
			Vehicule vehicule = new Vehicule();
			vehicule.setCodeInterne(_codeInterne);
			vehicule.setImmatriculation(_immatriculation);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date utildate = simpleDateFormat.parse(_dateMiseEnCirculation);
			vehicule.setDateMiseEnCirculation(utildate);

			// Insérer
			this.em.persist(vehicule);

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
	public List<Vehicule> rechercherTousLesVehicules() {
		String queryString = "select v from Vehicule v";
		Query query = this.em.createQuery(queryString);
		return query.getResultList();
	}

	@Override
	public Vehicule rechercherVehiculeParImmatriculation(String _immariculation) {
		String queryString = "select v from Vehicule v where v.immatriculation = :immat";
		Query query = this.em.createQuery(queryString);
		query.setParameter("immat", _immariculation);
		return (Vehicule) query.getSingleResult();
	}

	@Override
	public Vehicule rechercherVehiculeParId(Long _id) {
		// Find retourne l'entité si elle existe sinon null
		return this.em.find(Vehicule.class, _id);

		// GetReference retourne l'entité si elle existe sinon elle lance une exception
		// return this.em.getReference(Vehicule.class, _id);
	}

	@Override
	public void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne) {
		// Chercher le vehicule
		Vehicule vehicule = this.em.find(Vehicule.class, _id);
		if (vehicule != null) {
			EntityTransaction etx = null;
			try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();

				// Modifier l'entité
				// La modification ne nécessite pas d'instruction particulière
				vehicule.setCodeInterne(_codeInterne);

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
	public void supprimerVehiculeParId(Long _id) {
		// Chercher le vehicule
		Vehicule vehicule = this.em.find(Vehicule.class, _id);
		if (vehicule != null) {
			EntityTransaction etx = null;
			try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();

				// Supprimer l'entité
				this.em.remove(vehicule);

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
	protected void finalize() throws Throwable {
		if ((this.em != null) && this.em.isOpen()) {
			try {
				this.em.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.finalize();
	}

	@Override
	public long insererVehicule(Vehicule _vehicule) {
		EntityTransaction etx = null;
		try {
			// Initialiser une transaction JPA
			etx = this.em.getTransaction();
			etx.begin();

			// Insérer
			this.em.persist(_vehicule);

			// Commiter la transaction JPA
			etx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (etx != null) {
				etx.rollback();
			}
		}
		return _vehicule.getId();

	}

	@Override
	public void modifierVehiculeCodeInterneParId(Vehicule _vehicule) {
		EntityTransaction etx = null;
		try {
			// Initialiser une transaction JPA
			etx = this.em.getTransaction();
			etx.begin();

			// Pour modifier l'entité il faut la rattaché au contexte persisant
			this.em.merge(_vehicule);

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
	public void supprimerVehiculeParId(Vehicule _vehicule) {
		EntityTransaction etx = null;
		try {
			// Initialiser une transaction JPA
			etx = this.em.getTransaction();
			etx.begin();

			// Supprimer l'entité
			this.em.remove(_vehicule);

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
