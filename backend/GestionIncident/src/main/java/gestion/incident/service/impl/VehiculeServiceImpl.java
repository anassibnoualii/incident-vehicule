package gestion.incident.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gestion.incident.service.VehiculeService;
import gestion.incident.service.dto.VehiculeDto;
import gestion.incident.service.mapper.VehiculeMapper;
import jpa.vehicule.dao.Vehicule;
import jpa.vehicule.dao.VehiculeDao;
import jpa.vehicule.dao.VehiculeDaoFactory;

@Service
public class VehiculeServiceImpl implements VehiculeService {
	
	private VehiculeDao vehiculeDao;

	public VehiculeServiceImpl() {
		this.vehiculeDao=VehiculeDaoFactory.getVehiculeDao(VehiculeDaoFactory.JPA_DAO);
	}

	@Override
	public void creerVehicule(VehiculeDto vehiculeDto) {
		// TODO Auto-generated method stub
		Vehicule v=VehiculeMapper.vehiculeDtoToVehicule(vehiculeDto);
		vehiculeDao.insererVehicule(v);

	}

	@Override
	public VehiculeDto getVehiculeParImmatriculation(String immatriculation) {
		
		Vehicule v=vehiculeDao.rechercherVehiculeParImmatriculation(immatriculation);
		
		VehiculeDto vDto=VehiculeMapper.vehiculeToVehiculeDto(v);
		
		return vDto;
	}

	@Override
	public List<VehiculeDto> getTousLesVehicules() {
		List<Vehicule> listVehicule=vehiculeDao.rechercherTousLesVehicules();
		return listVehicule.stream().map(VehiculeMapper::vehiculeToVehiculeDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

}
