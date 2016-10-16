package BoutiquePhoto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.sun.javafx.property.adapter.ReadOnlyPropertyDescriptor.ReadOnlyListener;

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
	
	public ArrayList<Client> getlClients() {
		return lClients;
	}
	public void setlClients(ArrayList<Client> lClients) {
		this.lClients = lClients;
	}
	public ArrayList<Article> getlArticles() {
		return lArticles;
	}
	public void setlArticles(ArrayList<Article> lArticles) {
		this.lArticles = lArticles;
	}
	
	// Constructeur
	
	public Magasin(String pNom, String pNomGerant) {
		this.sNom = pNom;
		this.sNomGerant = pNomGerant;
		this.lArticles = new ArrayList<Article>();
		this.lClients = new ArrayList<Client>();
	}
	
	//méthodes
	
	/*
	 * Permet d'ajouter un article disponible dans le magasin
	 */
	public void ajouterArticle(Article pArticle) {
		this.lArticles.add(pArticle);
	}
	
	/*
	 * Permet de retirer un article du magasin
	 */
	public void retirerArticle(Article pArticle) {
		this.lArticles.remove(pArticle);
	}
	
	public void ajouterClient(Client pClient) {
		this.lClients.add(pClient);
	}
	
	public void supprimerClient(Client pClient) {
		this.lClients.remove(pClient);
	}
	
	/*
	 * Permet d'afficher la liste des articles loué par un client passé en parametre
	 */
	public void AfficherLocationsEnCours(Client pClient) 
	{
		System.out.println("Liste des locations du client : "+pClient.getsNom());
		for(Location currentLocation : pClient.getlLocations()) {
			if(currentLocation.getDateFin() == null) {
				System.out.println("Location du : "+currentLocation.getDateDebut().getTime());
				for(Article currentArticle : currentLocation.getlArticles()) {
					System.out.println("N° Ref : "+currentArticle.getnReference()+" | Nom : "+currentArticle.getsIntitule());
				}
			}
		}
		System.out.println();
	}
	
	/*
	 * Permet d'afficher la liste des articles du magasin en location trié soit par référence, marque, intitulé ou prix par jour de location
	 * (passé en paramètre) 
	 */
	public void AfficherListeArticle(String pCompare) {
		switch (pCompare) {
		case "ref":
			Comparator<Article> comparatorRef = new ArticleReferenceComparator();
			Collections.sort(this.lArticles, comparatorRef);
			System.out.println("Liste des articles disponibles à la location trié par reférence");
			break;
		case "marque":
			Comparator<Article> comparatorMarque = new ArticleMarqueComparator();
			Collections.sort(this.lArticles, comparatorMarque);
			System.out.println("Liste des articles disponibles à la location trié par marque");
			break;
		
		case "intitule":
			Comparator<Article> comparatorIntitule = new ArticleIntituleComparator();
			Collections.sort(this.lArticles, comparatorIntitule);
			System.out.println("Liste des articles disponibles à la location trié par intitule");
			break;
		case "prix":
			Comparator<Article> comparatorPrix = new ArticlePrixComparator();
			Collections.sort(this.lArticles, comparatorPrix);
			System.out.println("Liste des articles disponibles à la location trié par prix par jour de location");
			break;
		}
		for(Article currentArticle : this.lArticles) {
			System.out.println("Reference : "+currentArticle.getnReference()
					+" Intitule : "+currentArticle.getsIntitule()
					+" Marque : "+currentArticle.getsMarque()
					+" Prix : "+currentArticle.getdPrixParJour() 
					+" Stock : "+currentArticle.getnNbStock());
		}
		
	}
	
	public double calculerMontant(GregorianCalendar pGcDebut, GregorianCalendar pGcFin) throws IOException{
		double montantTotal = 0;
		GregorianCalendar currentGc = pGcDebut;
		
		while(currentGc.get(Calendar.MONTH) != (pGcFin.get(Calendar.MONTH)+1)) {
			StringBuilder sbDate = new StringBuilder();
			sbDate.append(currentGc.get(Calendar.YEAR));
			String valueMonth =Integer.toString(currentGc.get(Calendar.MONTH)+1);
			String realValueMonth ="";
			if(valueMonth.length() == 1) {
				realValueMonth = "0"+valueMonth;
			} else {
				realValueMonth = Integer.toString(currentGc.get(Calendar.MONTH)+1);
			}
			sbDate.append(realValueMonth);
			String date = sbDate.toString();
			BufferedReader bReader = new BufferedReader(new FileReader("Archives/"+date+".loc"));
			String ligneLue = bReader.readLine();
			while(ligneLue != null) {
				String chaine = ligneLue;
				String chaineTab[];
				chaineTab = chaine.split(",");
				String test = chaineTab[chaineTab.length-1];
				String montantTotalString ="";
				char[] tab = test.toCharArray();
				for (char c : tab) {
					if(Character.isDigit(c) || c == '.') {
						montantTotalString += c;
					}
				}
				montantTotal += Double.parseDouble(montantTotalString);
				ligneLue = bReader.readLine();
			}
			bReader.close();
			if((currentGc.get(Calendar.MONTH)+1) == 12) {
				currentGc = new GregorianCalendar(currentGc.get(Calendar.YEAR)+1, 0, 1);
			} else {
				currentGc = new GregorianCalendar(currentGc.get(Calendar.YEAR),currentGc.get(Calendar.MONTH)+1,1);
			}
		}
		return montantTotal;
	}
	
	
}
