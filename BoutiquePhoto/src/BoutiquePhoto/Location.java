package BoutiquePhoto;

//d�pendances

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Location {
	
	//attributs
	
	private GregorianCalendar DateDebut;
	private GregorianCalendar DateFin;
	private GregorianCalendar DateFinReelle;
	private UUID uReference;
	
	private ArrayList<Article> lArticles;
	
	/*
	 * Constructeur
	 */
	public Location (GregorianCalendar pCalendar)
	{
		this.DateDebut = pCalendar;
		this.DateFin = null;
		this.DateFinReelle = null;
		this.uReference = UUID.randomUUID();
		this.lArticles = new ArrayList<Article>();
	}
	
	
	//m�thodes
	
	public void EnregistrerLocation(Client pClient) throws IOException
	{
		String sNomFichier = "";
		String sContenuFichier = "";
		double MontantaFacturer = 0.0;
		
		sNomFichier += this.uReference+ "-"+ pClient.getsNom();
		File Dossier = new File("Locations");
		if(!Dossier.exists())
			Dossier.mkdir();
		
		File Fichier = new File("Locations/"+sNomFichier+".loc");
		//si le fichier existe d�j�, une simple modification est n�cessaire.
		if(Fichier.exists() && !Fichier.isDirectory())
		{
			this.ModifierLocation(pClient);
		}
		else
		{
			//On remplit la string a �crire dans le fichier avec tout les �l�ments n�c�ssaires
			sContenuFichier += "Informations Client : \n";
			sContenuFichier +=  pClient.getsNom() + " | ";
			sContenuFichier +=  pClient.getsAdress() + " | ";
			sContenuFichier +=  pClient.getsNum() + " \n";
			
			sContenuFichier += "Informations Articles : \n";
			for(Article currentArticle : this.getlArticles())
			{
				sContenuFichier += currentArticle.getnReference() + " | ";
				sContenuFichier += currentArticle.getsIntitule() + " | ";
				sContenuFichier += currentArticle.getdPrixParJour() + " \n";
				MontantaFacturer += (currentArticle.getdPrixParJour());
			}
			
			sContenuFichier += "Montant total : \n";
			sContenuFichier += MontantaFacturer + " \n";
			
			
			sContenuFichier += "Date de debut : " + this.DateDebut.getTime() + " \n";
			sContenuFichier += "Date de Fin : " + this.DateFin.getTime() + " \n";
			
			FileWriter fwFichier = new FileWriter("Locations/"+sNomFichier+".loc");
			fwFichier.write(sContenuFichier);
			fwFichier.close();
		}
		
		
	}
	
	public void ModifierLocation(Client pClient)
	{
		
	}
	
	public void archiverDonnees(Client pClient) throws IOException
	{
		// Permet de r�cup�rer l'ann�e et le mois de la fin de la location
		StringBuilder sbDate = new StringBuilder();
		sbDate.append(this.DateFinReelle.get(1));
		sbDate.append(this.DateFinReelle.get(2)+1);
		String date = sbDate.toString();
		File dossierArchive = new File("Archives");
		if(!dossierArchive.exists()) {
			dossierArchive.mkdir();
		}
		File fichierLoc = new File("Archives/"+date+".loc");
		// Cas fichier d�j� existant
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
	 * Fonction auxilliaire permettant de cr�er la chaine de caract�re � �crire dans le fichier d'archivage
	 */
	
	private String builder(Location pLocation, Client pClient) {
		String infoLoc = "Location n�"+pLocation.getuReference()+" du : "+pLocation.getDateDebut().getTime()+" au "+pLocation.getDateFinReelle().getTime()+"\n";
		infoLoc+="Effectu�e par : "+pClient.getsNom()+"\n";
		for(Article currentArticle : pLocation.getlArticles()) {
			infoLoc+="N� Ref : "+currentArticle.getnReference()
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
		this.DateFin = dateFin;
	}

	public GregorianCalendar getDateFinReelle() {
		return DateFinReelle;
	}

	public void setDateFinReelle(GregorianCalendar dateFinReelle) {
		this.DateFinReelle = dateFinReelle;
	}

	public ArrayList<Article> getlArticles() {
		return lArticles;
	}


	public void setlArticles(ArrayList<Article> lArticles) {
		this.lArticles = lArticles;
	}


	public UUID getuReference() {
		return uReference;
	}


	public void setuReference(UUID pReference) {
		this.uReference = pReference;
	}

}
