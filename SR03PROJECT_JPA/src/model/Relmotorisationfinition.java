package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the relmotorisationfinition database table.
 * 
 */
@Entity
@NamedQuery(name="Relmotorisationfinition.findAll", query="SELECT r FROM Relmotorisationfinition r")
public class Relmotorisationfinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrel;

	//bi-directional many-to-one association to Finition
	@ManyToOne
	@JoinColumn(name="id_finition")
	private Finition finition;

	//bi-directional many-to-one association to Motorisation
	@ManyToOne
	@JoinColumn(name="id_motorisation")
	private Motorisation motorisation;

	public Relmotorisationfinition() {
	}

	public int getIdrel() {
		return this.idrel;
	}

	public void setIdrel(int idrel) {
		this.idrel = idrel;
	}

	public Finition getFinition() {
		return this.finition;
	}

	public void setFinition(Finition finition) {
		this.finition = finition;
	}

	public Motorisation getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

}