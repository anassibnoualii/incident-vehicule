package gestion.incident.service.mapper;

import javax.swing.plaf.FileChooserUI;

import gestion.incident.service.dto.FicheIncidentDto;
import jpa.ficheIncident.dao.FicheIncident;

public class FicheIncidentMapper {

	public static FicheIncident ficheIncidentDtoToFicheIncident(FicheIncidentDto ficheIncidentDto) {
		FicheIncident ficheIncident = new FicheIncident();
		ficheIncident.setId(ficheIncidentDto.getId());
		ficheIncident.setDate_incident(ficheIncidentDto.getDate_incident());
		ficheIncident.setDescription_incident(ficheIncidentDto.getDescription_incident());
		ficheIncident.setIncident_critique(ficheIncidentDto.isIncident_critique());
		ficheIncident.setLieu_incident(ficheIncidentDto.getLieu_incident());
		ficheIncident.setNombre_voyageur(ficheIncidentDto.getNombre_voyageur());
		ficheIncident.setNumero_fiche(ficheIncidentDto.getNumero_fiche());
		ficheIncident.setVehicule(VehiculeMapper.vehiculeDtoToVehicule(ficheIncidentDto.getVehiculeDto()));
		return ficheIncident;
	}
	
	public static FicheIncidentDto ficheIncidentToFicheIncidentDto(FicheIncident ficheIncident) {
		FicheIncidentDto ficheIncidentDto=new FicheIncidentDto(); 
		ficheIncidentDto.setId(ficheIncident.getId());
		ficheIncidentDto.setDate_incident(ficheIncident.getDate_incident());
		ficheIncidentDto.setDescription_incident(ficheIncident.getDescription_incident());
		ficheIncidentDto.setIncident_critique(ficheIncident.isIncident_critique());
		ficheIncidentDto.setLieu_incident(ficheIncident.getLieu_incident());
		ficheIncidentDto.setNombre_voyageur(ficheIncident.getNombre_voyageur());
		ficheIncidentDto.setNumero_fiche(ficheIncident.getNumero_fiche());
		ficheIncidentDto.setVehiculeDto(VehiculeMapper.vehiculeToVehiculeDto(ficheIncident.getVehicule()));
		return ficheIncidentDto;
	}

}
