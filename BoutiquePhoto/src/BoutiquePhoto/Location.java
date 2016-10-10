package BoutiquePhoto;

//dépendances

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Location {
	
	//attributs
	
	private GregorianCalendar DateDebut;
	private GregorianCalendar DateFin;
	private ArrayList<Article> lArticles;
	
	/*
	 * Constructeur
	 */
	public Location (GregorianCalendar pCalendar)
	{
		this.DateDebut = pCalendar;
		this.DateFin = null;
		this.lArticles = new ArrayList<Article>();
	}
	
	
	//méthodes
	
	public void archiverDonnees()
	{
		
	}
	
	
	//accesseurs
	
	public GregorianCalendar getDateDebut() {
		return this.DateDebut; 
	}
	public void setDateDebut(GregorianCalendar dateDebut) {
		DateDebut = dateDebut;
	}
	public GregorianCalendar getDateFin() {
		return this.DateFin;
	}
	public void setDateFin(GregorianCalendar dateFin) {
		DateFin = dateFin;
	}


	public ArrayList<Article> getlArticles() {
		return lArticles;
	}


	public void setlArticles(ArrayList<Article> lArticles) {
		this.lArticles = lArticles;
	}

}
