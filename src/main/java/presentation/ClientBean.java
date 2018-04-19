package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import domaine.Client;
import service.ClientService;

@ManagedBean(name = "clientbean")
@SessionScoped
public class ClientBean {

	//////////// Proprietes ////////////////

	// 1. Declaration de classe domaine.Client comme proprietée du beans
	// et instatiation immediate à celle du bean
	private Client client = new Client();
	
	private List<Client> listeClients;

	private ClientService serviceC;
/*
	// Propritées managées de la classe client
	@ManagedProperty(name="nom", value = "PIGNON")
	public String nom; 
	@ManagedProperty(name="prenom", value = "PIGNON")
	public String prenom; 
*/	
	
	
	
	// 2. Constructeur
//	public ClientBean(Client client) {
//		super();
//		this.client = client;
//		this.serviceC = new ClientService();
//	}
	
	public ClientBean() {
		super();
		this.serviceC = new ClientService();
	}


	// 3. Getter/Setter pour gestion inderecte des proprietés client
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClients() {		
		// 1. Instantiation service
		//ClientService serviceC = new ClientService();
	
		// 2. Appel services depuis le bean
		// ----- GETALL 
		List<Client> list = this.serviceC.getListeClients();
		
		this.listeClients = list;
				
		return this.listeClients;
	}
	//////////// Methodes ////////////////
	public Object inscriptionClient() {

		// la Signature (retour Object) est documentée dans doc JSF commandButton /
		// attribut action

		// 1. Instantiation service

		// 2. Appel services depuis le bean
		// ----- INSERT a partir de formulaire
		boolean insert = this.serviceC.createNewClient(this.client);

		if (insert) {
			return "inscriptionOK";
		}
		return "inscriptionKO";
	}
	


	

}
