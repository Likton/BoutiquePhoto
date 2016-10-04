package BoutiquePhoto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Magasin {

	public static void main(String[] args) {
		Article art1 = new Article(14, 2, "marque1", "intitule1", 56);
		Article art2 = new Article(11, 4, "marque1", "intitule1", 41);
		Article art3 = new Article(13, 5, "marque1", "intitule1", 20);
		Article art4 = new Article(12, 6, "marque1", "intitule1", 80);
		ArrayList<Article> maListe = new ArrayList<Article>();
		maListe.add(art1);
		maListe.add(art2);
		maListe.add(art3);
		maListe.add(art4);
		Comparator<Article> comparator = new ArticlePrixComparator();
		for(Article currentArticle : maListe) {
			System.out.println("Ref "+currentArticle.getnReference()+" Prix : "+currentArticle.getdPrixParJour());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		Collections.sort(maListe,comparator);
		for(Article currentArticle : maListe) {
			System.out.println("Ref : "+currentArticle.getnReference()+" Prix : "+currentArticle.getdPrixParJour());
		}
	}
	
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
	
	public void AfficherListeArticle() {
		
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
