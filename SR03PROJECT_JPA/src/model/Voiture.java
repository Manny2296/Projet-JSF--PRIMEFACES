package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the voiture database table.
 * 
 */
@Entity
@NamedQuery(name="Voiture.findAll", query="SELECT v FROM Voiture v")
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int tarif;

	//bi-directional many-to-one association to Reloptionsuppvoiture
	@OneToMany(mappedBy="voiture")
	private List<Reloptionsuppvoiture> reloptionsuppvoitures;

	//bi-directional many-to-one association to Couleur
	@ManyToOne
	@JoinColumn(name="id_couleur")
	private Couleur couleur;

	//bi-directional many-to-one association to Modele
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;

	public Voiture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTarif() {
		return this.tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public List<Reloptionsuppvoiture> getReloptionsuppvoitures() {
		return this.reloptionsuppvoitures;
	}

	public void setReloptionsuppvoitures(List<Reloptionsuppvoiture> reloptionsuppvoitures) {
		this.reloptionsuppvoitures = reloptionsuppvoitures;
	}

	public Reloptionsuppvoiture addReloptionsuppvoiture(Reloptionsuppvoiture reloptionsuppvoiture) {
		getReloptionsuppvoitures().add(reloptionsuppvoiture);
		reloptionsuppvoiture.setVoiture(this);

		return reloptionsuppvoiture;
	}

	public Reloptionsuppvoiture removeReloptionsuppvoiture(Reloptionsuppvoiture reloptionsuppvoiture) {
		getReloptionsuppvoitures().remove(reloptionsuppvoiture);
		reloptionsuppvoiture.setVoiture(null);

		return reloptionsuppvoiture;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

}