package BoutiquePhoto;

import java.util.List;

public class Magasin {

	//attributs
	
	private String sNom;
	private String sNomGerant;
	private List<Client> lClients;
	private List<Article> lArticles;
	
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
