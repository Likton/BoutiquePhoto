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
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
		if(pArticle.getnNbStock() > 0) {
			this.lArticles.add(pArticle);
		} else {
			System.out.println("Vous ne pouvez pas ajouter d'articles si vous n'en n'avez pas en stock");
		}
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
		System.out.println("Liste des locations du client : "+pClient.getsNom()+" | "+pClient.getuRef());
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
	
	/*
	 * Permet de calculer le montant des recettes de toutes les locations compris entre une période donnée
	 */
	public double calculerMontant(GregorianCalendar pGcDebut, GregorianCalendar pGcFin) throws IOException{
		double montantTotal = 0;
		// on déclare une date courant qu'on initialise avec la date de début passé en parametre
		// utile pour le parcours de fichier
		GregorianCalendar currentGc = pGcDebut;
		ArrayList<GregorianCalendar> lGc = new ArrayList<GregorianCalendar>();
		// on ajoute cette date dans notre liste
		lGc.add(currentGc);
		long test = differenceMois(pGcDebut, pGcFin);
		//On ajoute dans notre liste chaque mois != de la date de début et de fin
		for(int i=0; i<test;i++) {
			// gestion du cas si la période donnée en param s'étale sur 2 années
			if(currentGc.get(Calendar.MONTH)+1 == 12) {
				currentGc = new GregorianCalendar(currentGc.get(Calendar.YEAR)+1,0,1);
			} else {
				currentGc = new GregorianCalendar(currentGc.get(Calendar.YEAR),currentGc.get(Calendar.MONTH)+1,1);
			}
			lGc.add(currentGc);
		}
		for(GregorianCalendar current : lGc) {
			System.out.println(current.getTime());
		}
		for(GregorianCalendar current : lGc) {
			// permet d'obtenir l'année et le mois sous un format "yyyyMM"
			StringBuilder sbDate = new StringBuilder();
			sbDate.append(current.get(Calendar.YEAR));
			String valueMonth = Integer.toString(current.get(Calendar.MONTH)+1);
			String realValueMonth ="";
			// Permet de modifier les mois à un chiffre en un mois à deux chiffres (ex : 01)
			if(valueMonth.length() == 1) {
				realValueMonth = "0"+valueMonth;
			} else {
				realValueMonth = Integer.toString(current.get(Calendar.MONTH)+1);
			}
			sbDate.append(realValueMonth);
			String date = sbDate.toString();
			// on ouvre notre fichier d'archivage en lecture
			BufferedReader bReader = new BufferedReader(new FileReader("Archives/"+date+".loc"));
			String ligneLue = bReader.readLine();
			while(ligneLue != null) {
				String chaineTab[];
				// on stocke chaque donnée séparée par une ',' dans un tableau
				chaineTab = ligneLue.split(",");
				// on récupère le montant total associé à la ligne
				String currentMontantTotal = chaineTab[chaineTab.length-1];
				String montantTotalString ="";
				char[] tab = currentMontantTotal.toCharArray();
				// permet d'enlever les caractères blancs stocké dans tab
				for (char c : tab) {
					if(Character.isDigit(c) || c == '.') {
						montantTotalString += c;
					}
				}
				montantTotal += Double.parseDouble(montantTotalString);
				ligneLue = bReader.readLine();
			}
			bReader.close();
		}
		return montantTotal;
	}
	
	/*
	 * méthode auxilliaire permettant de connaitre le nombre de mois séparant deux dates
	 */
	private static long differenceMois(GregorianCalendar pGc1, GregorianCalendar pGc2) {
		// durée d'un mois en millisecondes
		long dureeMois = 1000l * 60 * 60 * 24 * 30;
		long difference = Math.abs(pGc1.getTime().getTime()-pGc2.getTime().getTime());
		return Math.abs(difference/dureeMois);
	}
	
	
}
