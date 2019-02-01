package jpa.vehicule;

import java.sql.Date;

import jpa.ficheIncident.dao.FicheIncident;
import jpa.ficheIncident.dao.FicheIncidentDao;
import jpa.ficheIncident.dao.FicheIncidentDaoFactory;
import jpa.vehicule.dao.Vehicule;
import jpa.vehicule.dao.VehiculeDao;
import jpa.vehicule.dao.VehiculeDaoFactory;

public class TestJpaDaoVehicule {

	public static void main(String[] args) {
		TestJpaDaoVehicule.testerVehicule(VehiculeDaoFactory.JPA_DAO);
	}

	private static void testerVehicule(String typeDao) {
		try {

			VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);

			/*Vehicule veh = new Vehicule();
			veh.setCodeInterne("veh10");
			veh.setImmatriculation("AA-BB-CC");
			vehiculeDao.insererVehicule(veh);
			
			
			String str = "2010-03-31";
			Date date = Date.valueOf(str);
			Vehicule veh1 = new Vehicule();
			veh1.setCodeInterne("veh9");
			veh1.setImmatriculation("JJ-BB-CC");

			veh1.dateMiseEnCirculation(date);
			vehiculeDao.insererVehicule(veh1);*/
			
			
			
			/*Vehicule v=vehiculeDao.rechercherVehiculeParImmatriculation("AA-BB-CC");
			System.out.println(v);*/
			
			FicheIncidentDao ficheIncidentDao=FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			
			/*String str = "2010-03-31";
			Date date = Date.valueOf(str);
			Vehicule veh1 = vehiculeDao.rechercherVehiculeParId(1L);
			
			FicheIncident fiche=new FicheIncident(date, "123", true, "INSEA", 30, "description", veh1);
			
			ficheIncidentDao.insererFicheIncidentVoyage(fiche);*/
			
			//ficheIncidentDao.supprimerFicheIncidentVoyageParId(ficheIncidentDao.rechercherFicheIncidentVoyageParId(2L));
			
			/*String str = "2018-03-31";
			Date date = Date.valueOf(str);
			Vehicule veh1 = new Vehicule();
			veh1.setCodeInterne("veh15");
			veh1.setImmatriculation("XX-BB-CC");

			veh1.dateMiseEnCirculation(date);
			long id=vehiculeDao.insererVehicule(veh1);
			System.out.println(id);*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
