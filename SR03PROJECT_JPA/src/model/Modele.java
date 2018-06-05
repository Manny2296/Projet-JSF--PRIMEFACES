package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the modele database table.
 * 
 */
@Entity
@NamedQuery(name="Modele.findAll", query="SELECT m FROM Modele m")
public class Modele implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String marque;

	private String nom;

	private int prix;

	//bi-directional many-to-one association to Reljantemodele
	@OneToMany(mappedBy="modele")
	private List<Reljantemodele> reljantemodeles;

	//bi-directional many-to-one association to Relmotorisationmodele
	@OneToMany(mappedBy="modele")
	private List<Relmotorisationmodele> relmotorisationmodeles;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="modele")
	private List<Voiture> voitures;

	public Modele() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
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
	public List<Reljantemodele> getReljantemodeles() {
		return this.reljantemodeles;
	}

	public void setReljantemodeles(List<Reljantemodele> reljantemodeles) {
		this.reljantemodeles = reljantemodeles;
	}

	public Reljantemodele addReljantemodele(Reljantemodele reljantemodele) {
		getReljantemodeles().add(reljantemodele);
		reljantemodele.setModele(this);

		return reljantemodele;
	}

	public Reljantemodele removeReljantemodele(Reljantemodele reljantemodele) {
		getReljantemodeles().remove(reljantemodele);
		reljantemodele.setModele(null);

		return reljantemodele;
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
		relmotorisationmodele.setModele(this);

		return relmotorisationmodele;
	}

	public Relmotorisationmodele removeRelmotorisationmodele(Relmotorisationmodele relmotorisationmodele) {
		getRelmotorisationmodeles().remove(relmotorisationmodele);
		relmotorisationmodele.setModele(null);

		return relmotorisationmodele;
	}
	@JsonIgnore 
	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setModele(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setModele(null);

		return voiture;
	}

}