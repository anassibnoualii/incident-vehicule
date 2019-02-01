package gestion.incident.service;

import java.util.List;

import gestion.incident.service.dto.VehiculeDto;

public interface VehiculeService {

	public void creerVehicule(VehiculeDto vehiculeDto);

	public VehiculeDto getVehiculeParImmatriculation(String immatriculation);

	List<VehiculeDto> getTousLesVehicules();

}
