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
	
	public void AfficherLocationsEnCours() 
	{
		System.out.println("Liste des locations du client : "+this.getsNom());
		for(Location currentLocation : this.getlLocations()) {
				System.out.println("Location du : "+currentLocation.getDateDebut());
				for(Article currentArticle : currentLocation.getlArticles()) {
					System.out.println("N° Ref : "+currentArticle.getnReference()+" | Nom : "+currentArticle.getsIntitule());
				}
		}
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
}
