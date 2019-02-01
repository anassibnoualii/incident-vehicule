package jpa.ficheIncident.dao;

import java.util.List;

import jpa.vehicule.dao.Vehicule;
import jpa.vehicule.dao.VehiculeDao;
import jpa.vehicule.dao.VehiculeDaoFactory;

public class TestJpaDaoFiche {
	public static void main(String[] args) {
		TestJpaDaoFiche.testerFiche(FicheIncidentDaoFactory.JPA_DAO );
		}
		private static void testerFiche(String typeDao) {
		try {
			String im="BBBB";
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);	
			Vehicule vehicule = vehiculeDao.rechercherVehiculeParImmatriculation(im);
			List<FicheIncident> fiches=ficheDao.rechercherIncidentParVehicule(vehicule);
			for(FicheIncident fich :fiches ) {
				System.out.println(fich.getDescription_incident());
			}

			
			/*#####insertion
									
					Vehicule vehicule = vehiculeDao.rechercherVehiculeParId(id);
					FicheIncident fiche1 = new FicheIncident();
					fiche1.setLieu_incident("Marrakech");
					fiche1.setDescription_incident("mortel");
					fiche1.setIncident_critique(true);
					fiche1.setNombre_voyageur(123);
					fiche1.setNumero_fiche("F1234");
					String str = "2010-03-31";
					Date date = Date.valueOf(str);
					fiche1.setDate_incident(date);
					fiche1.setVehicule(vehicule);
					ficheDao.insererFicheIncidentVoyage(fiche1);*/
					
					
					
					//suppression long id = 6;

					/*FicheIncident fiche = ficheDao.rechercherFicheIncidentVoyageParId(id);
					ficheDao.supprimerFicheIncidentVoyageParId(fiche);*/
					
					
					
					//test de l'affichage de toutes les fiches
					/*List<FicheIncident> vehicules=ficheDao.rechercherTousLesFicheIncidentVoyages();
					for(FicheIncident f:vehicules ) {
						System.out.println(f.getNombre_voyageur());
					}*/
					
			
					} catch (Exception e) {
					e.printStackTrace();
					
					}
					}
		
		}
		

