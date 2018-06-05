package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the optionsupp database table.
 * 
 */
@Entity
@NamedQuery(name="Optionsupp.findAll", query="SELECT o FROM Optionsupp o")
public class Optionsupp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	private int prix;

	//bi-directional many-to-one association to Reloptionsuppvoiture
	@OneToMany(mappedBy="optionsupp")
	private List<Reloptionsuppvoiture> reloptionsuppvoitures;

	public Optionsupp() {
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

	public List<Reloptionsuppvoiture> getReloptionsuppvoitures() {
		return this.reloptionsuppvoitures;
	}

	public void setReloptionsuppvoitures(List<Reloptionsuppvoiture> reloptionsuppvoitures) {
		this.reloptionsuppvoitures = reloptionsuppvoitures;
	}

	public Reloptionsuppvoiture addReloptionsuppvoiture(Reloptionsuppvoiture reloptionsuppvoiture) {
		getReloptionsuppvoitures().add(reloptionsuppvoiture);
		reloptionsuppvoiture.setOptionsupp(this);

		return reloptionsuppvoiture;
	}

	public Reloptionsuppvoiture removeReloptionsuppvoiture(Reloptionsuppvoiture reloptionsuppvoiture) {
		getReloptionsuppvoitures().remove(reloptionsuppvoiture);
		reloptionsuppvoiture.setOptionsupp(null);

		return reloptionsuppvoiture;
	}

}