package BoutiquePhoto;

import java.util.GregorianCalendar;
import java.util.Date;

public class Article {

	//attributs
	
	private int nReference;
	private int nNbStock;
	private String sMarque;
	private String sIntitule;
	private double dPrixParJour;
	private boolean bDisponibilite;
	private boolean bNouvelleLocation;
		
	/*
	 * Constructeur paramétré pour initialisé les attributs généraux
	 */
	public Article(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour)
	{
		
		this.nReference = pReference;
		this.nNbStock = pNbStock;
		this.sMarque = pMarque;
		this.sIntitule = pIntitule;
		this.dPrixParJour = pPrixParJour;
		this.bDisponibilite = true;
		this.bNouvelleLocation = true;
		
	}
	
	//méthodes
	
	/*
	 * @function louer(Client pClient)
	 * @Param Client pClient
	 * @return boolean
	 * @Resume Location d'un article pour un client donné. La disponibilité passe à false pour cet article. Une location est crée à la date de location 
	 */
	public boolean louer(Client pClient)
	{
		this.bNouvelleLocation = true;
		if(this.bDisponibilite)
		{
			this.bDisponibilite = false;
			GregorianCalendar gcCurrentDate = new GregorianCalendar();
			Date TrialTime = new Date();
			gcCurrentDate.setTime(TrialTime);
			
			//on parcours toutes les locations du client
			for(Location currentLocation : pClient.getlLocations())
			{	
				//on regarde dans ces locations si l'heure actuelle serait la même qu'une des locations du client
				if( currentLocation.getDateDebut().get(12) == gcCurrentDate.get(12))
				{
					System.out.println(" même Minutes");
					//on regarde ensuite dans ces locations faites dans la même heure que l'heure actuelle, 
					//s'il n'y a pas une location faite dans les 2 minutes qui ont précédé.
					//si oui, on considère que l'article loué, s'ajoute à la liste des articles de la location courante
					if(currentLocation.getDateDebut().get(13) > gcCurrentDate.get(13)-5)
					{
						System.out.println("moins de 5 secondes");
						currentLocation.getlArticles().add(this);
						//bNouvelleLocation passe à false, car il n'est pas nécessaire d'en créer une
						this.bNouvelleLocation = false;
					}
				}
			}
			System.out.println("etat bNouvelleLocation : "+this.bNouvelleLocation);
			//si le client veut louer l'article avec plus de 2 minutes d'intervalle avec une autre de ses locations
			//une nouvelle location doit être créée.
			if(this.bNouvelleLocation)
			{
				
				System.out.println("nouvelle location");
				Location lLocation = new Location(gcCurrentDate);
				lLocation.getlArticles().add(this);
				pClient.getlLocations().add(lLocation);
				//sotkcage des données dans le fichier binaire
				lLocation.archiverDonnees();
			}
					
		}
		else
			System.out.println("pas disponible");
		
		return this.bDisponibilite;
	}
	
	
	/*
	 * @function RendreArticle(Client pClient)
	 * @Param Client pClient
	 * @return boolean
	 * @Resume fin de location d'un article pour un client donné. La disponibilité passe à true pour cet article. 
	 */
	public boolean FinLocation(Client pClient)
	{
		GregorianCalendar gcCurrentDate = new GregorianCalendar();
		int nIndexLocation = 0;
		boolean bRemoveLocation = false;
		
		//on teste si l'article est bien loué
		if(!this.bDisponibilite)
		{
			//on parcourt la liste des locations du client
			for(Location currentLocation : pClient.getlLocations())
			{
				//on parcourt la liste des articles pour les set à disponible
				for(Article currentArticle : currentLocation.getlArticles())
				{
					//on teste si la référence de l'article que l'on souhaite rendre, fait bien parti des références d'articles
					//des locations du client
					if(this.nReference == currentArticle.getnReference())
					{
						//on configure la date de fin de la location
						currentLocation.setDateFin(gcCurrentDate);
						//on stocke les données dans le fichier binaire
						currentLocation.archiverDonnees();
						bRemoveLocation = true;
						break;
					}
				}
				//cet index sert à conserver le numéro de la location qu'on souhaite modifier
				nIndexLocation ++;
			}
			
			if(bRemoveLocation)
			{
				//appel de la méthode pour set la disponibilité des articles d'une location, ici on veut les rendre disponible
				ChangerDisponibiliteArticles(pClient.getlLocations().get(nIndexLocation-1));
				//on supprime ensuite la location des locations en cours par le client
				pClient.getlLocations().remove(nIndexLocation-1);
			}
		}
		else
		{
			System.out.println("L'article n'est pas loué");
		}
		return this.bDisponibilite;
	}
	
	public void ChangerDisponibiliteArticles(Location pLocation)
	{
		for(int i=0; i < pLocation.getlArticles().size(); i++)
		{
					pLocation.getlArticles().get(i).setbDisponibilite(true);
		}
	}
	
	//accesseurs
	
	public int getnReference() {
		return nReference;
	}

	public void setnReference(int nReference) {
		this.nReference = nReference;
	}

	public int getnNbStock() {
		return nNbStock;
	}

	public void setnNbStock(int nNbStock) {
		this.nNbStock = nNbStock;
	}

	public String getsMarque() {
		return sMarque;
	}

	public void setsMarque(String sMarque) {
		this.sMarque = sMarque;
	}

	public String getsIntitule() {
		return sIntitule;
	}

	public void setsIntitule(String sIntitule) {
		this.sIntitule = sIntitule;
	}

	public double getdPrixParJour() {
		return dPrixParJour;
	}

	public void setdPrixParJour(double dPrixParJour) {
		this.dPrixParJour = dPrixParJour;
	}

	public boolean isbDisponibilite() {
		return bDisponibilite;
	}

	public void setbDisponibilite(boolean bDisponibilite) {
		this.bDisponibilite = bDisponibilite;
	}
	
	
}
