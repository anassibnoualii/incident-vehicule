package jpa.vehicule.dao;

import java.util.List;

public interface VehiculeDao {

	void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation);

	long insererVehicule(Vehicule _vehicule);

	List<Vehicule> rechercherTousLesVehicules();

	Vehicule rechercherVehiculeParId(Long _id);

	Vehicule rechercherVehiculeParImmatriculation(String _immatriculation);

	void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne);

	void modifierVehiculeCodeInterneParId(Vehicule _vehicule);

	void supprimerVehiculeParId(Long _id);

	void supprimerVehiculeParId(Vehicule _vehicule);
}
