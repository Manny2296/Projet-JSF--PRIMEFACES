package com.model.controler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import model.Modele;
import model.Motorisation;

@ManagedBean
@ViewScoped
public class ControlerObjectTest {
private List<ObjectTemplateTest> list_query;
private int modele_id;
private List<Motorisation> motorisation_by_model = new ArrayList();

public int getModele_id() {
	return modele_id;
}

public void setModele_id(int modele_id) {
	this.modele_id = modele_id;
}

@PostConstruct
  public void init() {
	this.list_query = new ArrayList<ObjectTemplateTest>();
	
	Client client = ClientBuilder.newClient();
	System.out.println("Test");
	this.list_query = client.target("http://localhost:8080/SR03PROJECT_REST/services/modeles")
									.request(MediaType.APPLICATION_JSON)
									.get(new GenericType<List<ObjectTemplateTest>>() {});
	  
	System.out.println(list_query.size());
								
  }

public List<Motorisation> getModelbyID(int id){
	Client client = ClientBuilder.newClient();
	this.motorisation_by_model = client.target("http://localhost:8080/SR03PROJECT_REST/services/motorisationBymodele?idmodele="+id)
			.request(MediaType.APPLICATION_JSON)
			.get(new GenericType<List<Motorisation>>() {});

System.out.println(motorisation_by_model.size());
return motorisation_by_model;
}

public List<Motorisation> getMotorisationsByModel() {
	if(getModele_id() == 0){
        return null;
        
     }
	else
		
		return(getModelbyID(getModele_id()));
		
	
}
public List<ObjectTemplateTest> getList_query() {
	return list_query;
}

public void setList_query(List<ObjectTemplateTest> list_query) {
	this.list_query = list_query;
}
  
	
}
