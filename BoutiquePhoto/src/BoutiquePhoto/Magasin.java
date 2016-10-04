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
	/*
	 * Permet d'afficher la liste des articles loué par un client passé en parametre
	 */
	public void AfficherLocationsEnCours(Client pClient) 
	{
		System.out.println("Liste des locations du client : "+pClient.getsNom());
		for(Location currentLocation : pClient.getlLocations()) {
			if(currentLocation.getDateFin() == null) {
				System.out.println("Location du : "+currentLocation.getDateDebut());
				for(Article currentArticle : currentLocation.getlArticles()) {
					System.out.println("N° Ref : "+currentArticle.getnReference()+" | Nom : "+currentArticle.getsIntitule());
				}
			}
		}
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
