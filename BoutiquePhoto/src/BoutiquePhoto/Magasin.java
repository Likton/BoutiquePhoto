package BoutiquePhoto;

import java.util.ArrayList;

public class Magasin {

	//attributs
	
	private String sNom;
	private String sNomGerant;
	private ArrayList<Client> lClients;
	private ArrayList<Article> lArticles;
	
	//accesseurs
	
	public String getsNom() {
		return sNom;
	}
	public void setsNom(String sNom) {
		this.sNom = sNom;
	}
	public String getsNomGerant() {
		return sNomGerant;
	}
	public void setsNomGerant(String sNomGerant) {
		this.sNomGerant = sNomGerant;
	}
	
	//méthodes
	
	public void AfficherLocationsEnCours() 
	{
		
	}
	
	public int CalculerMontant()
	{
		
		return 0;
	}
	
	public void Archiver()
	{
		
	}
	
	public void EnregistrerLocationConclue()
	{
		
	}
	
	
}
