package jpa.ficheIncident.dao;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import jpa.vehicule.dao.Vehicule;

@Entity
public class FicheIncident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private Date date_incident;
	private String numero_fiche;
	private boolean incident_critique;
	private String lieu_incident;
	private int nombre_voyageur;
	private String description_incident;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Vehicule vehicule;
	public FicheIncident() {
		super();
	}
	
	public FicheIncident(Date date_incident, String numero_fiche, boolean incident_critique, String lieu_incident,
			int nombre_voyageur, String description_incident, Vehicule vehicule) {
		super();
		this.date_incident = date_incident;
		this.numero_fiche = numero_fiche;
		this.incident_critique = incident_critique;
		this.lieu_incident = lieu_incident;
		this.nombre_voyageur = nombre_voyageur;
		this.description_incident = description_incident;
		this.vehicule = vehicule;
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
	
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Override
	public String toString() {
		return "FicheIncident [id=" + id + ", date_incident=" + date_incident + ", numero_fiche=" + numero_fiche
				+ ", incident_critique=" + incident_critique + ", lieu_incident=" + lieu_incident + ", nombre_voyageur="
				+ nombre_voyageur + ", description_incident=" + description_incident + ", vehicule=" + vehicule + "]";
	}
	
	
	
	
	
	

}
