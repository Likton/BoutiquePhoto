package BoutiquePhoto;

import java.util.GregorianCalendar;
import java.io.IOException;
import java.util.Date;

public class Article {

	//attributs
	
	private int nReference;
	private int nNbStock;
	private String sMarque;
	private String sIntitule;
	private double dPrixParJour;
	private boolean bNouvelleLocation;
		
	/*
	 * Constructeur param�tr� pour initialis� les attributs g�n�raux
	 */
	public Article(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour)
	{
		
		this.nReference = pReference;
		this.nNbStock = pNbStock;
		this.sMarque = pMarque;
		this.sIntitule = pIntitule;
		this.dPrixParJour = pPrixParJour;
		this.bNouvelleLocation = true;
		
	}
	
	//m�thodes
	
	/*
	 * @function louer(Client pClient)
	 * @Param Client pClient
	 * @return boolean
	 * @Resume Location d'un article pour un client donn�. La disponibilit� passe � false pour cet article. Une location est cr�e � la date de location 
	 */
	public int louer(Client pClient, int pNbArticleALoue) throws IOException
	{
		this.bNouvelleLocation = true;
		
		if(this.nNbStock > 0 && this.nNbStock-pNbArticleALoue >= 0)
		{
			GregorianCalendar gcCurrentDate = new GregorianCalendar();
			Date TrialTime = new Date();
			gcCurrentDate.setTime(TrialTime);
			
			//on parcours toutes les locations du client
			for(Location currentLocation : pClient.getlLocations())
			{	
				//on regarde dans ces locations si l'heure actuelle serait la m�me qu'une des locations du client
				if( currentLocation.getDateDebut().get(12) == gcCurrentDate.get(12))
				{
					//on regarde ensuite dans ces locations faites dans la m�me heure que l'heure actuelle, 
					//s'il n'y a pas une location faite dans les 2 minutes qui ont pr�c�d�.
					//si oui, on consid�re que l'article lou�, s'ajoute � la liste des articles de la location courante
					if(currentLocation.getDateDebut().get(13) > gcCurrentDate.get(13)-5)
					{
						for(int i=0; i < pNbArticleALoue; i++)
						{
							currentLocation.getlArticles().add(this);
							this.nNbStock --;
						}
						//currentLocation.setDateFin(pDateFin);
						//on stocke les donn�es dans le fichier texte
						try
						{
							currentLocation.EnregistrerLocation(pClient);
						}
						catch(IOException ioe)
						{
							System.out.println("Erreur d'E/S: "+ioe.getMessage());
						}
						//bNouvelleLocation passe � false, car il n'est pas n�cessaire d'en cr�er une
						this.bNouvelleLocation = false;
					}
				}
			}
			//si le client veut louer l'article avec plus de 2 minutes d'intervalle avec une autre de ses locations
			//une nouvelle location doit �tre cr��e.
			if(this.bNouvelleLocation)
			{
				Location lLocation = new Location(gcCurrentDate);
				for(int i=0; i < pNbArticleALoue; i++)
				{
					lLocation.getlArticles().add(this);
					this.nNbStock --;
				}
				//lLocation.setDateFin(pDateFin);
				pClient.getlLocations().add(lLocation);
				//on stocke les donn�es dans le fichier texte
				try
				{
					lLocation.EnregistrerLocation(pClient);
				}
				catch(IOException ioe)
				{
					System.out.println("Erreur d'E/S: "+ioe.getMessage());
				}
			}
						
		}
		else
			System.out.println("article pas disponible \n");
		
		return this.nNbStock;
	}
	
	
	/*
	 * @function RendreArticle(Client pClient)
	 * @Param Client pClient
	 * @return boolean
	 * @Resume fin de location d'un article pour un client donn�. La disponibilit� passe � true pour cet article. 
	 */
	public int FinLocation(Client pClient) throws IOException
	{
		GregorianCalendar gcCurrentDate = new GregorianCalendar();
		int nIndexLocation = 0;
		boolean bRemoveLocation = false;
		
			//on parcourt la liste des locations du client
			for(Location currentLocation : pClient.getlLocations())
			{
				//on parcourt la liste des articles pour les set � disponible
				for(Article currentArticle : currentLocation.getlArticles())
				{
					//on teste si la r�f�rence de l'article que l'on souhaite rendre, fait bien parti des r�f�rences d'articles
					//des locations du client
					if(this.nReference == currentArticle.getnReference())
					{
						//on configure la date de fin de la location
						currentLocation.setDateFinReelle(gcCurrentDate);
						if(currentLocation.getDateFin()!=currentLocation.getDateFinReelle())
						{
							currentLocation.ModifierLocation(pClient);
						}
						try
						{
							currentLocation.archiverDonnees();
						}
						catch(IOException ioe)
						{
							System.out.println("Erreur d'E/S: "+ioe.getMessage());
						}
						bRemoveLocation = true;
						break;
					}
				}
				//cet index sert � conserver le num�ro de la location qu'on souhaite modifier
				nIndexLocation ++;
			}
			
			if(bRemoveLocation)
			{
				//appel de la m�thode pour r�-incr�menter le nombre des articles d'une location, ici on veut les rendre disponible
				RemettreStockArticles(pClient.getlLocations().get(nIndexLocation-1));
				//on supprime ensuite la location des locations en cours par le client
				pClient.getlLocations().remove(nIndexLocation-1);
			}

		return this.nNbStock;
	}
	
	public void RemettreStockArticles(Location pLocation)
	{
		for(int i=0; i < pLocation.getlArticles().size(); i++)
		{
					pLocation.getlArticles().get(i).setnNbStock(pLocation.getlArticles().get(i).getnNbStock()+1);;
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
	
}
