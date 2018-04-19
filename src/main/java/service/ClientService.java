package service;

import java.util.ArrayList;

import domaine.Client;

public class ClientService {
	
	// TODO declaration DaoClient
	// private DaoClient daoC = new DaoClient();
	private ArrayList<Client> listC;
	
	
	
	public ClientService() {
		super();
		this.listC = new ArrayList<Client>();
		
		// TODO appel dao -------------------
		// listC = this.daoC.getAllClients();
		this.listC.add(new Client(1, "POPPINS", "Mary", 20, 1));
		this.listC.add(new Client(2, "MARLEY", "Bob", 30, 1));
	}

	public boolean createNewClient(Client c) {
		boolean insert=false;
		
		// TODO appel dao -------------------
		// insert = this.daoC.createClient(c);
		this.listC.add(c);
		
		insert = true;
		// ----------------------------------
		return insert;
	}
	
	public Client getOneClient(Client c) {
		
		// TODO appel dao -------------------
		// c = this.daoC.getClient(c.getIdClient());
		// ----------------------------------
		return c;
	}


	public boolean updateOneClient(Client c) {
		boolean updated=false;
		
		// TODO appel dao -------------------
		// updated = this.daoC.updateClient(c);
		
		updated=true;
		// ----------------------------------
		return updated;
	}
	

	public boolean deleteOneClient(Client c) {
		boolean deleted = false;
		
		// TODO appel dao -------------------
		// deleted = this.daoC.deleteClient(c);
		
		deleted = true;
		// ----------------------------------
		
		return deleted;
	}
	
	public ArrayList<Client> getListeClients(){
		 		
		// ----------------------------------
		return this.listC;
	}

}
