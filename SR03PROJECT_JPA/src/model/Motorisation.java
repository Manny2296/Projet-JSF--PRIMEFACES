package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the motorisation database table.
 * 
 */
@Entity
@NamedQuery(name="Motorisation.findAll", query="SELECT m FROM Motorisation m")
public class Motorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	private int prix;

	//bi-directional many-to-one association to Relmotorisationfinition
	@OneToMany(mappedBy="motorisation")
	private List<Relmotorisationfinition> relmotorisationfinitions;

	//bi-directional many-to-one association to Relmotorisationmodele
	@OneToMany(mappedBy="motorisation")
	private List<Relmotorisationmodele> relmotorisationmodeles;

	public Motorisation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
  @JsonIgnore
	public List<Relmotorisationfinition> getRelmotorisationfinitions() {
		return this.relmotorisationfinitions;
	}

	public void setRelmotorisationfinitions(List<Relmotorisationfinition> relmotorisationfinitions) {
		this.relmotorisationfinitions = relmotorisationfinitions;
	}

	public Relmotorisationfinition addRelmotorisationfinition(Relmotorisationfinition relmotorisationfinition) {
		getRelmotorisationfinitions().add(relmotorisationfinition);
		relmotorisationfinition.setMotorisation(this);

		return relmotorisationfinition;
	}

	public Relmotorisationfinition removeRelmotorisationfinition(Relmotorisationfinition relmotorisationfinition) {
		getRelmotorisationfinitions().remove(relmotorisationfinition);
		relmotorisationfinition.setMotorisation(null);

		return relmotorisationfinition;
	}
	  @JsonIgnore
	public List<Relmotorisationmodele> getRelmotorisationmodeles() {
		return this.relmotorisationmodeles;
	}

	public void setRelmotorisationmodeles(List<Relmotorisationmodele> relmotorisationmodeles) {
		this.relmotorisationmodeles = relmotorisationmodeles;
	}

	public Relmotorisationmodele addRelmotorisationmodele(Relmotorisationmodele relmotorisationmodele) {
		getRelmotorisationmodeles().add(relmotorisationmodele);
		relmotorisationmodele.setMotorisation(this);

		return relmotorisationmodele;
	}

	public Relmotorisationmodele removeRelmotorisationmodele(Relmotorisationmodele relmotorisationmodele) {
		getRelmotorisationmodeles().remove(relmotorisationmodele);
		relmotorisationmodele.setMotorisation(null);

		return relmotorisationmodele;
	}

}