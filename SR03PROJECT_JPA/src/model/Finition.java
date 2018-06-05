package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the finition database table.
 * 
 */
@Entity
@NamedQuery(name="Finition.findAll", query="SELECT f FROM Finition f")
public class Finition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	private int prix;

	//bi-directional many-to-one association to Relmotorisationfinition
	@OneToMany(mappedBy="finition")
	private List<Relmotorisationfinition> relmotorisationfinitions;

	public Finition() {
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

	public List<Relmotorisationfinition> getRelmotorisationfinitions() {
		return this.relmotorisationfinitions;
	}

	public void setRelmotorisationfinitions(List<Relmotorisationfinition> relmotorisationfinitions) {
		this.relmotorisationfinitions = relmotorisationfinitions;
	}

	public Relmotorisationfinition addRelmotorisationfinition(Relmotorisationfinition relmotorisationfinition) {
		getRelmotorisationfinitions().add(relmotorisationfinition);
		relmotorisationfinition.setFinition(this);

		return relmotorisationfinition;
	}

	public Relmotorisationfinition removeRelmotorisationfinition(Relmotorisationfinition relmotorisationfinition) {
		getRelmotorisationfinitions().remove(relmotorisationfinition);
		relmotorisationfinition.setFinition(null);

		return relmotorisationfinition;
	}

}