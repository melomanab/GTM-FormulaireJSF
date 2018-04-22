package service;

import java.util.ArrayList;

import domaine.Client;
import domaine.Compte;

public class CompteService {
	
	private ArrayList<Compte> listComptes;
	
	public CompteService() {
		super();
		this.listComptes = new ArrayList<Compte>();
		
		// TODO appel dao -------------------
		// listC = this.daoC.getAllClients();
		this.listComptes.add(new Compte(1));
		this.listComptes.add(new Compte(2));
	}
	
	public ArrayList<Compte> getlistComptes(){
		return this.listComptes;
	}

}
