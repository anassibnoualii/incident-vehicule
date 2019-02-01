package gestion.incident.service.mapper;

import gestion.incident.service.dto.VehiculeDto;
import jpa.vehicule.dao.Vehicule;

public class VehiculeMapper {

	public static VehiculeDto vehiculeToVehiculeDto(Vehicule vehicule) {
		VehiculeDto vehiculeDto = new VehiculeDto();
		vehiculeDto.setCodeInterne(vehicule.getCodeInterne());
		vehiculeDto.setImmatriculation(vehicule.getImmatriculation());
		return vehiculeDto;
	}

	public static Vehicule vehiculeDtoToVehicule(VehiculeDto vehiculeDto) {
		Vehicule vehicule = new Vehicule();
		vehicule.setCodeInterne(vehiculeDto.getCodeInterne());
		vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
		return vehicule;
	}

}
