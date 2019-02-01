package gestion.incident.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gestion.incident.service.FicheIncidentService;
import gestion.incident.service.dto.FicheIncidentDto;

@RestController
@RequestMapping(value = "/api")
public class FicheIncidentResource {
	
	private FicheIncidentService ficheIncidentService;
	
	@Autowired
	public FicheIncidentResource(FicheIncidentService ficheIncidentService) {
		super();
		this.ficheIncidentService = ficheIncidentService;
	}
	
	@RequestMapping(value="/ficheIncident/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody FicheIncidentDto getFicheId(@PathVariable long id) {
		FicheIncidentDto ficheIncidentDto=ficheIncidentService.getFicheIncidentById(id);
		return ficheIncidentDto;
	}
	
	@RequestMapping(value="/ficheIncident",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody FicheIncidentDto creerFicheIncident(@RequestBody FicheIncidentDto ficheIncidentDto) {
		ficheIncidentService.creerFicheIncident(ficheIncidentDto);
		return ficheIncidentDto;
	}
	
	@RequestMapping(value="/ficheIncident/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void supprimerFicheIncident(@PathVariable long id) {
		ficheIncidentService.supprimerFicheIncidentById(id);
	}
	
	@RequestMapping(value="/ficheIncident",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody FicheIncidentDto modifierFicheIncident(@RequestBody FicheIncidentDto ficheIncidentDto) {
		ficheIncidentService.modifierFicheIncident(ficheIncidentDto);
		return ficheIncidentDto;
	} 
	
	@RequestMapping(value="/ficheIncidentByImmatriculation/{imm}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<FicheIncidentDto> getFicheIncidentByImmatriculation(@PathVariable String imm) {
		List<FicheIncidentDto> listFicheIncidentDto=ficheIncidentService.getFicheIncidentByImmatriculation(imm);
		return listFicheIncidentDto; 
	}
	
	@RequestMapping(value="/ficheIncident",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<FicheIncidentDto> getFicheIncidentList() {
		List<FicheIncidentDto> ficheIncidentDtoList=ficheIncidentService.getFicheIncidentList();
		return ficheIncidentDtoList;
	}

}
