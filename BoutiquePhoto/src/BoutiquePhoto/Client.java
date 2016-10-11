package BoutiquePhoto;

import java.util.ArrayList;

public class Client {

	private String sNom;
	private ArrayList<Location> lLocations;	
	
	
	//Constructeurs
	public Client()
	{
		this.sNom = "Jacquy";
		this.lLocations = new ArrayList<Location>();		
	}
	
	public Client(String pNom)
	{
		this.sNom = pNom;
		this.lLocations = new ArrayList<Location>();
	}
	
	//méthodes	
	
	//accesseur
	
	public String getsNom() {
		return sNom;
	}

	public void setsNom(String sNom) {
		this.sNom = sNom;
	}

	public ArrayList<Location> getlLocations() {
		return lLocations;
	}

	public void setlLocations(ArrayList<Location> lLocations) {
		this.lLocations = lLocations;
	}
}
