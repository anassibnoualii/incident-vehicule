package jpa.vehicule.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Vehicule.
 */
@Entity
@Table(name = "vehicule")
public class Vehicule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code_interne", nullable = false)
	private String codeInterne;

	@Column(name = "immatriculation", nullable = false)
	private String immatriculation;

	@Column(name = "date_mise_en_circulation")
	private Date dateMiseEnCirculation;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeInterne() {
		return this.codeInterne;
	}

	public Vehicule codeInterne(String codeInterne) {
		this.codeInterne = codeInterne;
		return this;
	}

	public void setCodeInterne(String codeInterne) {
		this.codeInterne = codeInterne;
	}

	public String getImmatriculation() {
		return this.immatriculation;
	}

	public Vehicule immatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
		return this;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDateMiseEnCirculation() {
		return this.dateMiseEnCirculation;
	}

	public Vehicule dateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
		return this;
	}

	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", codeInterne=" + codeInterne + ", immatriculation=" + immatriculation
				+ ", dateMiseEnCirculation=" + dateMiseEnCirculation + "]";
	}
	
	

}
