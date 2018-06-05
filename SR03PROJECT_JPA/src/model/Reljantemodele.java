package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reljantemodele database table.
 * 
 */
@Entity
@NamedQuery(name="Reljantemodele.findAll", query="SELECT r FROM Reljantemodele r")
public class Reljantemodele implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrel;

	//bi-directional many-to-one association to Jante
	@ManyToOne
	@JoinColumn(name="id_jante")
	private Jante jante;

	//bi-directional many-to-one association to Modele
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;

	public Reljantemodele() {
	}

	public int getIdrel() {
		return this.idrel;
	}

	public void setIdrel(int idrel) {
		this.idrel = idrel;
	}

	public Jante getJante() {
		return this.jante;
	}

	public void setJante(Jante jante) {
		this.jante = jante;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

}