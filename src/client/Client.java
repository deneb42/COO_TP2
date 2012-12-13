package client;

public class Client {

	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private int id;
	CatClient categorie;
	
	public Client(String nom, String prenom, String email, String telephone, int id, CatClient cat) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.categorie = cat;
		this.telephone = telephone;		
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
		msg.append(categorie);
		msg.append("\n");
		
		return msg.toString();
	}
	
	
	public void connexion(){
		//ToDo
	}
}
