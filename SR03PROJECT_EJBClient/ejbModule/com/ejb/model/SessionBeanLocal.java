package com.ejb.model;

import java.util.List;

import javax.ejb.Local;

import model.Couleur;
import model.Finition;
import model.Jante;
import model.Modele;
import model.Motorisation;
import model.Optionsupp;

import model.Voiture;

@Local
public interface SessionBeanLocal {
	 public void updateVoiture(Voiture v);
	 public List<Voiture> getVoitures();
	 public List<Couleur> getCouleur();
	 public List<Modele> getVoitureByID(int id);
	 public List<Modele> getModeles();
	 public List<Motorisation> getMotorisations();
	 public List<Jante> getJantes();
	 public List<Motorisation> getMotorisationByModele(int idmodele);
	 //List<Finition> getFinitions();
	//List<Optionsupp> getOptionsupp();
	//List<Relfinitionmotorisation> getRelfinitionmotorisation();
	//List<Relfinitionmotorisation> getMotorisationsByFinitions(int idfinition);
}
