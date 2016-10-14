package BoutiquePhoto;

import java.util.ArrayList;
import java.util.UUID;

public class Client {
	
	private UUID uRef;
	private String sNom;
	private String sAdress;
	private String sNum;
	
	private ArrayList<Location> lLocations;	
	
	
	//Constructeurs
	public Client()
	{
		this.uRef = UUID.randomUUID();
		this.sNom = "Jacquy";
		this.lLocations = new ArrayList<Location>();		
	}
	
	public Client(String pNom)
	{
		this.uRef = UUID.randomUUID();
		this.sNom = pNom;
		this.lLocations = new ArrayList<Location>();
	}
	
	//m�thodes	
	
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
	
	public String getsAdress() {
		return sAdress;
	}

	public void setsAdress(String sAdress) {
		this.sAdress = sAdress;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

}
