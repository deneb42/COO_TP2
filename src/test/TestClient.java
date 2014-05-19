package test;

import java.util.ArrayList;

import client.Adherents;
import client.Client;
import client.Personnel;
import client.Simple;

/**
 * Classe de création des clients
 * @author BADIE & BLOIS
 *
 */
public class TestClient {

	/**
	 * Initialisation des lcients
	 * @return
	 */
	public static ArrayList<Client> populeClient() {
		ArrayList<Client> c = new ArrayList<Client>();
		c.add(new Client("Blois", "Benjamin", "benjblois@gmail.com", "0607080910", Personnel.getCat()));
		c.add(new Client("BADIE","Jean", "jean.badie@gmail.com", "0607080919", Adherents.getCat()));
		c.add(new Client("LYET","Thomas", "thomas.lyet@gmail.com", "0607080919", Adherents.getCat()));
		c.add(new Client("Torres","Fernando", "fernan.orres@gmail.com", "0607080919", Simple.getCat()));
	
		return c;
	}

}
