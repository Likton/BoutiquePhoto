package BoutiquePhoto;

//dépendances

import java.util.Calendar;
import java.util.ArrayList;

public class Location {
	
	//attributs
	
	private Calendar DateDebut;
	private Calendar DateFin;
	private ArrayList<Article> lArticles;
	
	/*
	 * Constructeur
	 */
	public Location (Calendar pCalendar)
	{
		this.DateDebut = pCalendar;
		this.DateFin = null;
		this.lArticles = new ArrayList<Article>();
	}
	
	
	//méthode
	
	
	//accesseurs
	
	public Calendar getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(Calendar dateDebut) {
		DateDebut = dateDebut;
	}
	public Calendar getDateFin() {
		return DateFin;
	}
	public void setDateFin(Calendar dateFin) {
		DateFin = dateFin;
	}

}
