package test;

import java.util.ArrayList;

import client.*;

public class TestClient {
	
	public static void main(String[] args) {
		Adherents ad = new Adherents("ad", 100, 30);
		Personnel perso = new Personnel("perso");
		Simple simple = new Simple("simple");	
	
		ArrayList<Client> p = new ArrayList<Client>();
		int id = 0;
		p.add(new Client("Blois", "Benjamin", "benjblois@gmail.com", "0607080910", id, perso));
		id++;
		p.add(new Client("BADIE","Jean", "jean.badie@gmail.com", "0607080919",id, ad));
		id++;
		p.add(new Client("Torres","Fernando", "fernan.orres@gmail.com", "0607080919",id, simple));
		
		for(Client itp:p){
			System.out.println(itp.toString());
		}
	
	
	}

}
