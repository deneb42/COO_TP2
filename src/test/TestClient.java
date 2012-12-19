package test;

import java.util.ArrayList;

import client.Adherents;
import client.Client;
import client.Personnel;
import client.Simple;

public class TestClient {
	
	public static void main(String args[]) {
		ArrayList<Client> c = populeClient();
		
		for(Client itp:c){
			System.out.println(itp.toString());
		}
	}
	
	public static ArrayList<Client> populeClient() {
		ArrayList<Client> c = new ArrayList<Client>();
		int id = 0;
		c.add(new Client("Blois", "Benjamin", "benjblois@gmail.com", "0607080910", id, Personnel.getCat()));
		id++;
		c.add(new Client("BADIE","Jean", "jean.badie@gmail.com", "0607080919",id, Adherents.getCat()));
		id++;
		c.add(new Client("Torres","Fernando", "fernan.orres@gmail.com", "0607080919",id, Simple.getCat()));
	
		return c;
	}

}
