package BoutiquePhoto;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Locale;

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
		if(this.bDisponibilite)
		{
			this.bDisponibilite = false;
			GregorianCalendar gcCurrentDate = new GregorianCalendar();
			
			//on parcours toutes les locations du client
			for(Location currentLocation : pClient.getlLocations())
			{	
				//on regarde dans ces locations si l'heure actuelle serait la même qu'une des locations du client
				if( currentLocation.getDateDebut().HOUR == gcCurrentDate.HOUR)
				{
					//on regarde ensuite dans ces locations faites dans la même heure que l'heure actuelle, 
					//s'il n'y a pas une location faite dans les 2 minutes qui ont précédé.
					//si oui, on considère que l'article loué, s'ajoute à la liste des articles de la location courante
					if(currentLocation.getDateDebut().MINUTE > gcCurrentDate.MINUTE-2)
					{
						currentLocation.getlArticles().add(this);
						//bNouvelleLocation passe à false, car il n'est pas nécessaire d'en créer une
						this.bNouvelleLocation = false;
						//stockage des données dans le fichier binaire
						currentLocation.archiverDonnees();
					}
				}
			}
			//si le client veut louer l'article avec plus de 2 minutes d'intervalle avec une autre de ses locations
			//une nouvelle location doit être créée.
			if(this.bNouvelleLocation)
			{
				Location lLocation = new Location(gcCurrentDate);
				lLocation.getlArticles().add(this);
				pClient.getlLocations().add(lLocation);
				//sotkcage des données dans le fichier binaire
				lLocation.archiverDonnees();
			}
					
		}
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
		if(!this.bDisponibilite)
		{
			
			for(Location currentLocation : pClient.getlLocations())
			{
				for(Article currentArticle : currentLocation.getlArticles())
				{
					if(this.nReference == currentArticle.getnReference())
					{
						currentLocation.setDateFin(gcCurrentDate);
						int nIndexLocation;
						
					}
				}
			}
		}
		else
		{
			System.out.println("L'article n'est pas loué");
		}
		return this.bDisponibilite;
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
