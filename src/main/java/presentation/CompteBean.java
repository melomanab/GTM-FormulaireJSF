package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domaine.Client;
import domaine.Compte;
import service.ClientService;
import service.CompteService;

@ManagedBean(name = "comptebean")
@SessionScoped
public class CompteBean {

	// 1. Declaration de classe domaine.Client comme proprietée du beans
	// et instatiation immediate à celle du bean
	private Compte compte;
	private CompteService servCompte;
	private ArrayList<Compte> allComptes;

	// Contructor
	public CompteBean() {
		super();
		this.compte = new Compte();
		this.servCompte = new CompteService();
	}

	// Getter/Setter listeComptes
	public List<Compte> getAllComptes() {
		return this.servCompte.getlistComptes();
	}

	//////////// Methodes 'action' ////////////////
	public Object actionListeComptesClient() {
		// TODO affichier comptes liés à un client et pas toutes les comptes
		
		this.allComptes = (ArrayList<Compte>) this.getAllComptes();
		return "liste-comptes";
	}

}
