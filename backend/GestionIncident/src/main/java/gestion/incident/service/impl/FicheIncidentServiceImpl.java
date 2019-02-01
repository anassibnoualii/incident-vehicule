package gestion.incident.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gestion.incident.service.FicheIncidentService;
import gestion.incident.service.dto.FicheIncidentDto;
import gestion.incident.service.mapper.FicheIncidentMapper;
import jpa.ficheIncident.dao.FicheIncident;
import jpa.ficheIncident.dao.FicheIncidentDao;
import jpa.ficheIncident.dao.FicheIncidentDaoFactory;
import jpa.vehicule.dao.Vehicule;
import jpa.vehicule.dao.VehiculeDao;
import jpa.vehicule.dao.VehiculeDaoFactory;

@Service
public class FicheIncidentServiceImpl implements FicheIncidentService {
	private VehiculeDao vehiculeDao;
	private FicheIncidentDao ficheIncidentDao;

	public FicheIncidentServiceImpl() {
		this.ficheIncidentDao=FicheIncidentDaoFactory.getFicheIncidentDao(FicheIncidentDaoFactory.JPA_DAO);
		this.vehiculeDao=VehiculeDaoFactory.getVehiculeDao(VehiculeDaoFactory.JPA_DAO);
	}

	@Override
	public void creerFicheIncident(FicheIncidentDto ficheIncidentDto) {
		FicheIncident ficheIncident=FicheIncidentMapper.ficheIncidentDtoToFicheIncident(ficheIncidentDto);
		Vehicule vehicule=ficheIncident.getVehicule();
		long idVehicule=vehiculeDao.insererVehicule(vehicule);
		ficheIncident.setVehicule(vehiculeDao.rechercherVehiculeParId(idVehicule));
		ficheIncidentDao.insererFicheIncidentVoyage(ficheIncident);

	}

	@Override
	public FicheIncidentDto getFicheIncidentById(long id) {
		FicheIncident ficheIncident=ficheIncidentDao.rechercherFicheIncidentVoyageParId(id);
		FicheIncidentDto ficheIncidentDto=FicheIncidentMapper.ficheIncidentToFicheIncidentDto(ficheIncident);
		return ficheIncidentDto;
	}

	@Override
	public void supprimerFicheIncidentById(long id) {
		ficheIncidentDao.supprimerFicheIncidentParId(id);
	}

	@Override
	public List<FicheIncidentDto> getFicheIncidentByImmatriculation(String imm) {
		List<FicheIncident> listFicheIncident=ficheIncidentDao.rechercherIncidentParImmatriculation(imm);
		return listFicheIncident.stream().map(FicheIncidentMapper::ficheIncidentToFicheIncidentDto)
								.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<FicheIncidentDto> getFicheIncidentList() {
		List<FicheIncident> ficheIncidentList=ficheIncidentDao.rechercherTousLesFicheIncidentVoyages();
		return ficheIncidentList.stream().map(FicheIncidentMapper::ficheIncidentToFicheIncidentDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public void modifierFicheIncident(FicheIncidentDto ficheIncidentDto) {
		FicheIncident ficheIncident=FicheIncidentMapper.ficheIncidentDtoToFicheIncident(ficheIncidentDto);
		ficheIncidentDao.modifierFicheIncidentVoyage(ficheIncident);
		
	}

}
