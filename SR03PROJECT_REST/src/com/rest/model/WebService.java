package com.rest.model;

import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.ejb.model.SessionBeanLocal;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class WebService {

	@EJB
	private SessionBeanLocal voiture;

	@GET
	@Path("/voiture")
	public Response getVoitures() {

		return Response.ok(this.voiture.getVoitures()).build();
	}
	// Ce service peut être invoqué avec une URL à partir d’un navigateur comme suit
	// :

	// http://localhost:8080/SR03PROJECT_REST/service/voiture
	@GET
	@Path("/couleur")
	public Response getCouleur() {

		System.out.println("Entre en el get");
		return Response.ok(this.voiture.getCouleur()).build();
	}

	@GET
	@Path("/voiturebyId")
	public Response getVoitureByid(@QueryParam("id") int id) {
		return Response.ok(this.voiture.getVoitureByID(id)).build();
	}

	@GET
	@Path("/motorisation")
	public Response getMotorisationByFinition() {
		return Response.ok(this.voiture.getMotorisations()).build();
	}

	@GET
	@Path("/jantes")
	public Response getJantes() {
		return Response.ok(this.voiture.getJantes()).build();
	}
	@GET
	@Path("/motorisationBymodele")
	public Response getMotorisationByModele(@QueryParam("idmodele") int idmodele) {
		
		return Response.ok(this.voiture.getMotorisationByModele(idmodele)).build();
	}
	// Antoine
	@GET
	@Path("/modeles")
	public Response getModeles() {
		return Response.ok(this.voiture.getModeles()).build();
	}

	/*@GET
	@Path("/finitions")
	public Response getFinitions() {
		return Response.ok(this.voiture.getFinitions()).build();
	}

	@GET
	@Path("/optionsup")
	public Response getOptionsupp() {
		return Response.ok(this.voiture.getOptionsupp()).build();
	}

	@GET
	@Path("/finitionMotorisation")
	public Response getRelfinitionmotorisation() {
		return Response.ok(this.voiture.getRelfinitionmotorisation()).build();
	}

	@GET
	@Path("/motorisationsByFinitions")
	public Response getMotorisationsByFinitions(@QueryParam("idfinition") int idfinition) {
		return Response.ok(this.voiture.getMotorisationsByFinitions(idfinition)).build();
	}*/
	// http://localhost:8080/PROJETSR03_REST/service/getMotorisationsByFinitions?idfinition=1
	
}
