package BoutiquePhoto;

//dépendances

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
	
	/**
	 * Constructeur
	 * @param pCalendar
	 */
	public Location (GregorianCalendar pCalendar)
	{
		this.DateDebut = pCalendar;
		this.DateFin = null;
		this.DateFinReelle = null;
		this.uReference = UUID.randomUUID();
		this.lArticles = new ArrayList<Article>();
	}
	
	
	//méthodes
	/**
	 * Description : Enregistre la location dans un fichier .loc au format texte, lisible par le gérant du magasin
	 * A faire: Le fichier doit pouvoir être édité, si une location est simplement modifiée (pas de new loc)
	 * @param pClient
	 * @throws IOException
	 */
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
		//si le fichier existe déjà, une simple modification est nécessaire.
		if(Fichier.exists() && !Fichier.isDirectory())
		{
			this.ModifierLocation(pClient);
		}
		else
		{
			//On remplit la string a écrire dans le fichier avec tout les éléments nécéssaires
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
			sContenuFichier += MontantaFacturer*(Math.abs(this.DateFin.get(Calendar.DAY_OF_YEAR)-this.DateDebut.get(Calendar.DAY_OF_YEAR)))+" \n";
			
			sContenuFichier += "Date de debut : " + this.DateDebut.getTime() + " \n";
			sContenuFichier += "Date de Fin : " + this.DateFin.getTime() + " \n";
			
			FileWriter fwFichier = new FileWriter("Locations/"+sNomFichier+".loc");
			fwFichier.write(sContenuFichier);
			fwFichier.close();
		}
		
		
	}
	
	/**
	 * Description: Cette méthode permet l'édition du fichier de loc, pour inscrire la date de fin réelle, et mettre en conséquence le montant réel à payé.
	 * A faire: doit pouvoir gérer l'affiliation à une autre location
	 * @param pClient
	 * @throws IOException
	 */
	public void ModifierLocation(Client pClient) throws IOException {
		String sNomFichier = "";
		String sContenuFichier = "";
		double MontantaFacturer = 0.0;
		
		sNomFichier += this.uReference+ "-"+ pClient.getsNom();

//		FileWriter fwModifFichier = new FileWriter("Location/"+sNomFichier+".loc", true);
//		
//		sContenuFichier += "Date de Fin réelle : " + this.DateFinReelle.getTime() + " \n";
//		for(Article currentArticle : this.getlArticles())
//		{
//			MontantaFacturer += (currentArticle.getdPrixParJour());
//		}
//		sContenuFichier += "Montant total à payer: "+MontantaFacturer*(Math.abs(this.DateFinReelle.get(Calendar.DAY_OF_YEAR)-this.DateDebut.get(Calendar.DAY_OF_YEAR)));
//		fwModifFichier.write(sContenuFichier);
//		fwModifFichier.close();
	}
	
	/**
	 * Desciption: Archive les données d'une location, dans un fichier de location qui rassemble toutes les locations du même mois
	 * @param pClient
	 * @throws IOException
	 */
	public void archiverDonnees(Client pClient) throws IOException
	{
		// Permet de récupérer l'année et le mois de la fin de la location
		StringBuilder sbDate = new StringBuilder();
		sbDate.append(this.DateFinReelle.get(Calendar.YEAR));
		String valueMonth =Integer.toString(this.DateFinReelle.get(Calendar.MONTH)+1);
		String realValueMonth ="";
		if(valueMonth.length() == 1) {
			realValueMonth = "0"+valueMonth;
		} else {
			realValueMonth = Integer.toString(this.DateFinReelle.get(Calendar.MONTH)+1);
		}
		sbDate.append(realValueMonth);
		String date = sbDate.toString();
		File dossierArchive = new File("Archives");
		if(!dossierArchive.exists()) {
			dossierArchive.mkdir();
		}
		File fichierLoc = new File("Archives/"+date+".loc");
		char[] tab = builder(this, pClient).toCharArray();
		// Cas fichier déjà existant
		if(fichierLoc.exists()) {
			stockerChar(fichierLoc, tab, true);
		} 
		// cas fichier non existant 
		else {
			stockerChar(fichierLoc, tab, false);
		}
	}
	
	/**
	 * Description: fonction auxilliaire permettant l'écriture des informations de la location dans un fichier
	 * @param pFile
	 * @param tab
	 * @param pAppend
	 * @throws IOException
	 */
	private void stockerChar(File pFile,  char[] tab, boolean pAppend) throws IOException {
		DataOutputStream fluxSortieBinaire = new DataOutputStream(new FileOutputStream(pFile,pAppend));
		for(char current : tab) {
			fluxSortieBinaire.writeChar(current);
		}
		fluxSortieBinaire.close();
	}
	
	/**
	 * Description: Fonction auxilliaire permettant de créer la chaine de caractère à écrire dans le fichier d'archivage
	 * @param pLocation
	 * @param pClient
	 * @return
	 */
	private String builder(Location pLocation, Client pClient) {
		double montantTotal = 0;
		long nbJour = differenceDate(pLocation.getDateDebut(), pLocation.getDateFinReelle());
		System.out.println(nbJour);
		String infoLoc = pLocation.getuReference()+","+pLocation.getDateDebut().getTime()+","+pLocation.getDateFinReelle().getTime();
		infoLoc+=","+pClient.getsNom();
		for(Article currentArticle : pLocation.getlArticles()) {
			infoLoc+=","+currentArticle.getnReference()
				+","+currentArticle.getsIntitule()
				+","+currentArticle.getdPrixParJour();
			montantTotal += nbJour*currentArticle.getdPrixParJour();
		}
		infoLoc+=","+montantTotal;
		infoLoc+="\n";

		return infoLoc;
	}
	
	/**
	 * Description: fonction auxilliaire permettant d'obtenir le nombre de jour séparant deux dates
	 * @param pGc1
	 * @param pGc2
	 * @return
	 */
	private long differenceDate(GregorianCalendar pGc1, GregorianCalendar pGc2) {
		int difference = 0;
		difference = Math.abs(pGc1.get(Calendar.DAY_OF_YEAR)-pGc2.get(Calendar.DAY_OF_YEAR));
		return difference+1;
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
