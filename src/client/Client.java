package client;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import courses.Panier;

public class Client extends Observable{
	private static int nbClient=0;
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private int id;
	private CatClient categorie;
	private Panier sonPanier;
	
	public Client(String nom, String prenom, String email, String telephone, CatClient cat, Set<Observer> obs) {
		this(nom, prenom, email, telephone, cat);
		for(Observer o:obs) {
			addObserver(o);
			sonPanier.addObserver(o);
		}
	}
	
	public Client(String nom, String prenom, String email, String telephone, CatClient cat) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.categorie = cat;
		this.id = nbClient++;
		this.telephone = telephone;	
		sonPanier = new Panier(this);
	}
	
	public void connexion(CatClient cat){
		setChanged();
		notifyObservers();
		categorie = cat;
		sonPanier.calculReduc();
	}
	public void deconnexion(){
		setChanged();
		notifyObservers();
		categorie = Simple.getCat();
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append("Client \nNom du Client : ");
		msg.append(nom);
		msg.append("\nPrénom du client : ");
		msg.append(prenom);
		msg.append("\nid : ");
		msg.append(id);
		msg.append("\neMail : ");
		msg.append(email);
		msg.append("\nTelephone : ");
		msg.append(telephone);
		msg.append("\nCategorie : ");	
		msg.append(categorie.toString());
			
		msg.append("\n");
		
		return msg.toString();
	}
	
	/* ***********************************
	 * Getter & Setter	
	 ************************************/
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setEmail(String email) { this.email = email; }
	public void setTelephone(String telephone) { this.telephone = telephone; }
	public void setId(int id) { this.id = id; }
	public void setCategorie(CatClient categorie) { this.categorie = categorie; }
	public void setSonPanier(Panier sonPanier) { this.sonPanier = sonPanier; }
	
	public String getNom() { return nom; }
	public String getPrenom() {	return prenom; }
	public String getEmail() { return email; }
	public String getTelephone() { return telephone; }
	public int getId() { return id; }
	public CatClient getCategorie() { return categorie; }
	public Panier getSonPanier() { return sonPanier; }
}
