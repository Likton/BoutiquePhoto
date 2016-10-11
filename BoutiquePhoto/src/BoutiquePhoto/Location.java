package BoutiquePhoto;

//d�pendances

import java.util.GregorianCalendar;
import java.util.ArrayList;
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
	
	
	//m�thodes
	
	public void EnregistrerLocation(Client pClient) throws IOException
	{
		String sNomFichier = "";
		String sContenuFichier = "";
		double MontantaFacturer = 0.0;
		
		sNomFichier += this.nReference + pClient.getsNom();
		
		File Dossier = new File("locations");
		if(!Dossier.exists())
			Dossier.mkdir();
		
		File Fichier = new File(sNomFichier+".loc");
		//si le fichier existe d�j�, une simple modification est n�cessaire.
		if(Fichier.exists() && !Fichier.isDirectory())
		{
			this.ModifierLocation(pClient);
		}
		else
		{
			FileWriter fwFichier = new FileWriter(sNomFichier+".loc");
			//On remplit la string a �crire dans le fichier avec tout les �l�ments n�c�ssaires
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
			
			
			sContenuFichier += "Date de debut : " + this.DateDebut + " \n";
			sContenuFichier += "Date de Fin : " + this.DateFin + " \n";
			sContenuFichier += "Date de Rendu : " + this.DateFinReelle + " \n";
			
			try
			{
				fwFichier.write(sContenuFichier);
			}
			catch(IOException ioe)
			{
				System.out.println("Erreur d'E/S: "+ioe.getMessage());
			}
		}
		
		
	}
	
	public void ModifierLocation(Client pClient)
	{
		
	}
	
	public void archiverDonnees() throws IOException
	{
		// Cr�ation du fichier de location
		StringBuilder sbDate = new StringBuilder();
		sbDate.append(this.DateFin.get(1));
		sbDate.append(this.DateFin.get(2)+1);
		String date = sbDate.toString();
		File fichierLoc = new File("Archives/"+date);
		
		// Cas fichier d�j� existant
		if(fichierLoc.exists()) {
			FileWriter fWriter = new FileWriter(fichierLoc,true);
			String infoLoc = ""
			fWriter.write("");
			
		} 
		// cas fichier non existant 
		else {
			FileWriter fWriter = new FileWriter(fichierLoc);
		}
		
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
