package gestion.incident.service;

import java.util.List;

import gestion.incident.service.dto.FicheIncidentDto;

public interface FicheIncidentService {
	
	public void creerFicheIncident(FicheIncidentDto ficheIncidentDto);

	public FicheIncidentDto getFicheIncidentById(long id);

	public void supprimerFicheIncidentById(long id);

	public List<FicheIncidentDto> getFicheIncidentByImmatriculation(String imm);

	public List<FicheIncidentDto> getFicheIncidentList();

	public void modifierFicheIncident(FicheIncidentDto ficheIncidentDto);

}
