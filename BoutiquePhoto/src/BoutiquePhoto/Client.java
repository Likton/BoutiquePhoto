package BoutiquePhoto;
/**
 * @author Guitton Lucas
 * @author Chardenal Matthieu
 */

import java.util.ArrayList;
import java.util.UUID;

public class Client {
	
	private UUID uRef;
	private String sNom;
	private String sAdress;
	private String sNum;
	
	private ArrayList<Location> lLocations;	
	
	
	/**
	 * Constructeur non-paramétré
	 */
	public Client()
	{
		this.setuRef(UUID.randomUUID());
		this.sNom = "Jules Auguste Valentin Arthur";
		this.sAdress = "";
		this.sNum = "";
		this.lLocations = new ArrayList<Location>();		
	}
	
	/**
	 * Constructeur paramètré faible
	 * @param pNom
	 */
	public Client(String pNom)
	{
		this.setuRef(UUID.randomUUID());
		this.sNom = pNom;
		this.lLocations = new ArrayList<Location>();
		this.sAdress = "";
		this.sNum = "";
	}
	
	/**
	 * Constructeur paramétré complet
	 * @param pNom
	 * @param pAdress
	 * @param pNum
	 */
	public Client(String pNom, String pAdress, String pNum) {
		this.setuRef(UUID.randomUUID());
		this.sNom = pNom;
		this.sAdress = pAdress;
		this.sNum = pNum;
		this.lLocations = new ArrayList<Location>();
	}
	
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

	public UUID getuRef() {
		return uRef;
	}

	public void setuRef(UUID uRef) {
		this.uRef = uRef;
	}

}
