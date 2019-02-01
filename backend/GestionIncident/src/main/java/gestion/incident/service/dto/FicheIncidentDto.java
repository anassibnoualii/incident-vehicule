package gestion.incident.service.dto;

import java.sql.Date;

public class FicheIncidentDto {
	
	private Long id;
	private Date date_incident;
	private String numero_fiche;
	private boolean incident_critique;
	private String lieu_incident;
	private int nombre_voyageur;
	private String description_incident;
	private VehiculeDto vehiculeDto; 
	
	public FicheIncidentDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_incident() {
		return date_incident;
	}

	public void setDate_incident(Date date_incident) {
		this.date_incident = date_incident;
	}

	public String getNumero_fiche() {
		return numero_fiche;
	}

	public void setNumero_fiche(String numero_fiche) {
		this.numero_fiche = numero_fiche;
	}

	public boolean isIncident_critique() {
		return incident_critique;
	}

	public void setIncident_critique(boolean incident_critique) {
		this.incident_critique = incident_critique;
	}

	public String getLieu_incident() {
		return lieu_incident;
	}

	public void setLieu_incident(String lieu_incident) {
		this.lieu_incident = lieu_incident;
	}

	public int getNombre_voyageur() {
		return nombre_voyageur;
	}

	public void setNombre_voyageur(int nombre_voyageur) {
		this.nombre_voyageur = nombre_voyageur;
	}

	public String getDescription_incident() {
		return description_incident;
	}

	public void setDescription_incident(String description_incident) {
		this.description_incident = description_incident;
	}

	public VehiculeDto getVehiculeDto() {
		return vehiculeDto;
	}

	public void setVehiculeDto(VehiculeDto vehiculeDto) {
		this.vehiculeDto = vehiculeDto;
	}
	
	
	
	

}
