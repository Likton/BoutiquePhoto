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
	
	//m�thodes
	
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
	 * Permet d'afficher la liste des articles lou� par un client pass� en parametre
	 */
	public void AfficherLocationsEnCours(Client pClient) 
	{
		System.out.println("Liste des locations du client : "+pClient.getsNom()+" | "+pClient.getuRef());
		for(Location currentLocation : pClient.getlLocations()) {
			if(currentLocation.getDateFin() == null) {
				System.out.println("Location du : "+currentLocation.getDateDebut().getTime());
				for(Article currentArticle : currentLocation.getlArticles()) {
					System.out.println("N� Ref : "+currentArticle.getnReference()+" | Nom : "+currentArticle.getsIntitule());
				}
			}
		}
		System.out.println();
	}
	
	/*
	 * Permet d'afficher la liste des articles du magasin en location tri� soit par r�f�rence, marque, intitul� ou prix par jour de location
	 * (pass� en param�tre) 
	 */
	public void AfficherListeArticle(String pCompare) {
		switch (pCompare) {
		case "ref":
			Comparator<Article> comparatorRef = new ArticleReferenceComparator();
			Collections.sort(this.lArticles, comparatorRef);
			System.out.println("Liste des articles disponibles � la location tri� par ref�rence");
			break;
		case "marque":
			Comparator<Article> comparatorMarque = new ArticleMarqueComparator();
			Collections.sort(this.lArticles, comparatorMarque);
			System.out.println("Liste des articles disponibles � la location tri� par marque");
			break;
		
		case "intitule":
			Comparator<Article> comparatorIntitule = new ArticleIntituleComparator();
			Collections.sort(this.lArticles, comparatorIntitule);
			System.out.println("Liste des articles disponibles � la location tri� par intitule");
			break;
		case "prix":
			Comparator<Article> comparatorPrix = new ArticlePrixComparator();
			Collections.sort(this.lArticles, comparatorPrix);
			System.out.println("Liste des articles disponibles � la location tri� par prix par jour de location");
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
	 * Permet de calculer le montant des recettes de toutes les locations compris entre une p�riode donn�e
	 */
	public double calculerMontant(GregorianCalendar pGcDebut, GregorianCalendar pGcFin) throws IOException{
		double montantTotal = 0;
		// on d�clare une date courant qu'on initialise avec la date de d�but pass� en parametre
		// utile pour le parcours de fichier
		GregorianCalendar currentGc = pGcDebut;
		ArrayList<GregorianCalendar> lGc = new ArrayList<GregorianCalendar>();
		// on ajoute cette date dans notre liste
		lGc.add(currentGc);
		long test = differenceMois(pGcDebut, pGcFin);
		//On ajoute dans notre liste chaque mois != de la date de d�but et de fin
		for(int i=0; i<test;i++) {
			// gestion du cas si la p�riode donn�e en param s'�tale sur 2 ann�es
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
			// permet d'obtenir l'ann�e et le mois sous un format "yyyyMM"
			StringBuilder sbDate = new StringBuilder();
			sbDate.append(current.get(Calendar.YEAR));
			String valueMonth = Integer.toString(current.get(Calendar.MONTH)+1);
			String realValueMonth ="";
			// Permet de modifier les mois � un chiffre en un mois � deux chiffres (ex : 01)
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
				// on stocke chaque donn�e s�par�e par une ',' dans un tableau
				chaineTab = ligneLue.split(",");
				// on r�cup�re le montant total associ� � la ligne
				String currentMontantTotal = chaineTab[chaineTab.length-1];
				String montantTotalString ="";
				char[] tab = currentMontantTotal.toCharArray();
				// permet d'enlever les caract�res blancs stock� dans tab
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
	 * m�thode auxilliaire permettant de connaitre le nombre de mois s�parant deux dates
	 */
	private static long differenceMois(GregorianCalendar pGc1, GregorianCalendar pGc2) {
		// dur�e d'un mois en millisecondes
		long dureeMois = 1000l * 60 * 60 * 24 * 30;
		long difference = Math.abs(pGc1.getTime().getTime()-pGc2.getTime().getTime());
		return Math.abs(difference/dureeMois);
	}
	
	
}
