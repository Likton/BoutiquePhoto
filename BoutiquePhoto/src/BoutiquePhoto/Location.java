package BoutiquePhoto;

//dépendances

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Location {
	
	//attributs
	
	private GregorianCalendar DateDebut;
	private GregorianCalendar DateFin;
	private GregorianCalendar DateFinReelle;
	private int nReference;
	
	private ArrayList<Article> lArticles;
	
	/*
	 * Constructeur
	 */
	public Location (GregorianCalendar pCalendar)
	{
		this.DateDebut = pCalendar;
		this.DateFin = null;
		this.DateFinReelle = null;
		this.nReference = 1;
		this.lArticles = new ArrayList<Article>();
	}
	
	
	//méthodes
	
	public void EnregistrerLocation(Client pClient)
	{
		String sNomFichier = "";
		String sContenuFichier = "";
		double MontantaFacturer = 0.0;
		
		sNomFichier += this.nReference + pClient.getsNom();
		
		File Fichier = new File("locations/"+sNomFichier);
		if(Fichier.exists() && !Fichier.isDirectory())
		{
			this.ModifierLocation(pClient);
		}
		
		sContenuFichier += "Informations Client : \n";
		sContenuFichier +=  pClient.getsNom() + " \n";
		sContenuFichier +=  pClient.getsAdress() + " \n";
		sContenuFichier +=  pClient.getsNum() + " \n";
		
		sContenuFichier += "Informations Articles : \n";
		for(Article currentArticle : this.getlArticles())
		{
			sContenuFichier += currentArticle.getnReference() + " \n";
			sContenuFichier += currentArticle.getsIntitule() + " \n";
			sContenuFichier += currentArticle.getdPrixParJour() + " \n";
			MontantaFacturer += currentArticle.getdPrixParJour();
		}
		
		sContenuFichier += "Montant total : \n";
		sContenuFichier += MontantaFacturer + " \n";
		
		
		sContenuFichier += 
		
	}
	
	public void ModifierLocation(Client pClient)
	{
		
	}
	
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

	public GregorianCalendar getDateFinReelle() {
		return DateFinReelle;
	}


	public void setDateFinReelle(GregorianCalendar dateFinReelle) {
		DateFinReelle = dateFinReelle;
	}

}
