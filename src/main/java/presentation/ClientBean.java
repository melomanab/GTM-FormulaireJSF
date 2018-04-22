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

	private ClientService serviceC;
	
/* ATTENTION: Gestion de properietés avec @ManagedProperty ne marche pas 
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

	// Getter/Setter listeClients
	public List<Client> getListeClients() {				
		return this.serviceC.getListeClients();
	}
	
	//////////// Methodes 'action' ////////////////
	public Object actionInscription() {

		// la Signature (retour Object) est documentée dans doc JSF commandButton /
		// attribut action

		// 1. Instantiation service

		// 2. TODO appel service createNewClient depuis le bean
		// ----- INSERT a partir de formulaire
		Client nouveauClient = new Client (this.client.getNom(), 
				this.client.getPrenom(),
				this.client.getAge(), this.client.getIdConseiller());
		
		this.serviceC.getListeClients().add(nouveauClient);
		
		boolean insert = true;
		// boolean insert = this.serviceC.createNewClient(nouveauClient);

		if (insert) {
			return "inscriptionOK";
		}
		return "inscriptionKO";
	}
	
	public void actionSupprimer(Client item) {

		this.serviceC.getListeClients().remove(item);
	
	}
	
	public Object actionCharger(Client item) {
		
		// Modification etat courant du bean à l'item chosi 
		this.client = item;
		return "formulaireModification";
	}
	
	public Object actionModifier(Client item) {

		// Modification etat courant de l'item choisi à celui du bean
		item.setNom(this.client.getNom());
	
//		this.client.getAge();
//		this.client.getIdConseiller());
		return "modificationOK";
		
	
	}
	
	

}
