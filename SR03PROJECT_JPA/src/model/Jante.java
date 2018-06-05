package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jante database table.
 * 
 */
@Entity
@NamedQuery(name="Jante.findAll", query="SELECT j FROM Jante j")
public class Jante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	private int prix;

	//bi-directional many-to-one association to Reljantemodele
	@OneToMany(mappedBy="jante")
	private List<Reljantemodele> reljantemodeles;

	public Jante() {
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

	public List<Reljantemodele> getReljantemodeles() {
		return this.reljantemodeles;
	}

	public void setReljantemodeles(List<Reljantemodele> reljantemodeles) {
		this.reljantemodeles = reljantemodeles;
	}

	public Reljantemodele addReljantemodele(Reljantemodele reljantemodele) {
		getReljantemodeles().add(reljantemodele);
		reljantemodele.setJante(this);

		return reljantemodele;
	}

	public Reljantemodele removeReljantemodele(Reljantemodele reljantemodele) {
		getReljantemodeles().remove(reljantemodele);
		reljantemodele.setJante(null);

		return reljantemodele;
	}

}