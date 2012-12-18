package test;

import java.util.ArrayList;

import client.Adherents;
import client.Client;
import client.Personnel;
import client.Simple;

public class TestClient {
	
	public static void main(String args[]) {
		Adherents ad = new Adherents("adherent", 30);
		Personnel perso = new Personnel("perso");
		Simple simple = new Simple("simple");	
		
		ArrayList<Client> c = populeClient(ad, perso, simple);
		
		for(Client itp:c){
			System.out.println(itp.toString());
		}
	}
	
	public static ArrayList<Client> populeClient(Adherents ad, Personnel perso, Simple simple) {
		ArrayList<Client> c = new ArrayList<Client>();
		int id = 0;
		c.add(new Client("Blois", "Benjamin", "benjblois@gmail.com", "0607080910", id, perso));
		id++;
		c.add(new Client("BADIE","Jean", "jean.badie@gmail.com", "0607080919",id, ad));
		id++;
		c.add(new Client("Torres","Fernando", "fernan.orres@gmail.com", "0607080919",id, simple));
	
		return c;
	}

}
