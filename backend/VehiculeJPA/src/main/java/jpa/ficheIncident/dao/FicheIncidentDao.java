package jpa.ficheIncident.dao;

import java.util.List;

import jpa.vehicule.dao.Vehicule;

public interface FicheIncidentDao {
	void insererFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage);
	List<FicheIncident> rechercherTousLesFicheIncidentVoyages();
	FicheIncident rechercherFicheIncidentVoyageParId(Long _id);
	void modifierFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage);
	void supprimerFicheIncidentVoyageParId(FicheIncident _ficheIncidentVoyage);	
	List<FicheIncident> rechercherIncidentParVehicule(Vehicule _vehicule);
	void supprimerFicheIncidentParId(Long _id);
	List<FicheIncident> rechercherIncidentParImmatriculation(String immatriculation);

}
