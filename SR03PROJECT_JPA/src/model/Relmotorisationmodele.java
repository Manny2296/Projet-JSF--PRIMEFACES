package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the relmotorisationmodele database table.
 * 
 */
@Entity
@NamedQuery(name="Relmotorisationmodele.findAll", query="SELECT r FROM Relmotorisationmodele r")
public class Relmotorisationmodele implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrel;

	//bi-directional many-to-one association to Modele
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;

	//bi-directional many-to-one association to Motorisation
	@ManyToOne
	@JoinColumn(name="id_motorisation")
	private Motorisation motorisation;

	public Relmotorisationmodele() {
	}

	public int getIdrel() {
		return this.idrel;
	}

	public void setIdrel(int idrel) {
		this.idrel = idrel;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Motorisation getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

}