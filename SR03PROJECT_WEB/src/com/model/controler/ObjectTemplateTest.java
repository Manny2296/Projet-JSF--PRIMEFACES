package com.model.controler;

import model.Voiture;

public class ObjectTemplateTest {
	//Query q = em.createQuery("select v.idvoiture,m.nom,m.prix,c.couleur from Voiture v join v.modeles m  join v.couleur c");
   private int id;
   private String marque;
   private String nom;
   private int prix;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}



}