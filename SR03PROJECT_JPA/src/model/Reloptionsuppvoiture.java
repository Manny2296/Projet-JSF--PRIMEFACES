package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reloptionsuppvoiture database table.
 * 
 */
@Entity
@NamedQuery(name="Reloptionsuppvoiture.findAll", query="SELECT r FROM Reloptionsuppvoiture r")
public class Reloptionsuppvoiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrel;

	//bi-directional many-to-one association to Optionsupp
	@ManyToOne
	@JoinColumn(name="id_voiture")
	private Optionsupp optionsupp;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="id_optionsupp")
	private Voiture voiture;

	public Reloptionsuppvoiture() {
	}

	public int getIdrel() {
		return this.idrel;
	}

	public void setIdrel(int idrel) {
		this.idrel = idrel;
	}

	public Optionsupp getOptionsupp() {
		return this.optionsupp;
	}

	public void setOptionsupp(Optionsupp optionsupp) {
		this.optionsupp = optionsupp;
	}

	public Voiture getVoiture() {
		return this.voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

}