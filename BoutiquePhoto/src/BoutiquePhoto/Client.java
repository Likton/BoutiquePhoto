package BoutiquePhoto;

import java.util.ArrayList;

public class Client {

	private String sNom;
	private ArrayList<Location> lLocations;	
	
	
	
	
	//méthodes
	
	/*
	 * @function addLocation(Location pLocation, ArrayList<Article> plArticle
	 * @Param Location pLocation
	 * @Param ArrayList<Article> plArticle
	 * @return void
	 * @Resume Ajoute une location, 
	 */
	public void addLocation(Location pLocation)
	{
		
		
	}
	
	public void removeLocation(Location pLocation)
	{
		
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
