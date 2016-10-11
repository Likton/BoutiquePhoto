package BoutiquePhoto;

//dépendances

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
	
	
	//méthodes
	
	public void EnregistrerLocation(Client pClient) throws IOException
	{
		String sNomFichier = "";
		String sContenuFichier = "";
		double MontantaFacturer = 0.0;
		
		sNomFichier += this.nReference+ "-"+ pClient.getsNom();
		this.nReference ++;
		
		File Dossier = new File("Locations");
		if(!Dossier.exists())
			Dossier.mkdir();
		
		File Fichier = new File("Locations/"+sNomFichier+".loc");
		//si le fichier existe déjà, une simple modification est nécessaire.
		if(Fichier.exists() && !Fichier.isDirectory())
		{
			this.ModifierLocation(pClient);
		}
		else
		{
			FileWriter fwFichier = new FileWriter(sNomFichier+".loc");
			//On remplit la string a écrire dans le fichier avec tout les éléments nécéssaires
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
	
	public void archiverDonnees(Client pClient) throws IOException
	{
		// Permet de récupérer l'année et le mois de la fin de la location
		StringBuilder sbDate = new StringBuilder();
		sbDate.append(this.DateFinReelle.get(1));
		sbDate.append(this.DateFinReelle.get(2)+1);
		String date = sbDate.toString();
		File dossierArchive = new File("Archives");
		if(!dossierArchive.exists()) {
			dossierArchive.mkdir();
		}
		File fichierLoc = new File("Archives/"+date+".loc");
		// Cas fichier déjà existant
		if(fichierLoc.exists()) {
			FileWriter fWriter = new FileWriter(fichierLoc,true);
			fWriter.write(builder(this, pClient));
			fWriter.close();
		} 
		// cas fichier non existant 
		else {
			FileWriter fWriter = new FileWriter(fichierLoc);
			fWriter.write(builder(this, pClient));
			fWriter.close();
		}
	}
	
	/*
	 * Fonction auxilliaire permettant de créer la chaine de caractère à écrire dans le fichier d'archivage
	 */
	
	private String builder(Location pLocation, Client pClient) {
		String infoLoc = "Location n°"+pLocation.getnReference()+" du : "+pLocation.getDateDebut().getTime()+" au "+pLocation.getDateFinReelle().getTime()+"\n";
		infoLoc+="Effectuée par : "+pClient.getsNom()+"\n";
		for(Article currentArticle : pLocation.getlArticles()) {
			infoLoc+="N° Ref : "+currentArticle.getnReference()
				+" | Intitule : "+currentArticle.getsIntitule()
				+" | Prix par jour : "+currentArticle.getdPrixParJour()+"\n";
		}
		infoLoc+="------------------------------------ \n";
		return infoLoc;
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


	public int getnReference() {
		return nReference;
	}


	public void setnReference(int nReference) {
		this.nReference = nReference;
	}

}
