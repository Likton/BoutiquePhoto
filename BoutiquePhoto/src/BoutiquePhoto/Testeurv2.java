package BoutiquePhoto;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Testeurv2 {
	
	Magasin MonMagasin = new Magasin("MonMagasin","Moi");
	
	Client Lucas = new Client("Lucas", "32 rue Morray", "55-64-76");
	Client Matthieu = new Client("Matthieu", "123 rue de paul Berléan", "24-24-24");
	Client Prof = new Client("Audrey Queudet", "IUT de Nantes", "0216448979");
	
	DispositifAcquisition daArticle = new DispositifAcquisition(123, 123, "Sony", "Camera20MPX", 123.0, 123, "123");
	FondStudio fsArticle = new FondStudio(456, 1, "Phillips", "FondStudioWide", 456, 520, 740);
	MaterielTournageStabilisation mtsArticle = new MaterielTournageStabilisation(789, 2, "Panasonic", "Trépied", 12);
	Micro micArticle = new Micro(147, 147, "Sony", "MIC16056", 147, 22.4, true, 48.8);
	PanneauLED pledArticle = new PanneauLED(258, 3, "Phillips", "PanneauLED512", 258, 512);
	Reflecteur rArticle = new Reflecteur(369, 4, "Panasonic", "RéflecteurPhotoWide", 369, 128, 256);
	
	public void Initialisation() {
		MonMagasin.ajouterClient(Lucas);
		MonMagasin.ajouterClient(Matthieu);
		MonMagasin.ajouterClient(Prof);
		
		MonMagasin.ajouterArticle(daArticle);
		MonMagasin.ajouterArticle(fsArticle);
		MonMagasin.ajouterArticle(mtsArticle);
		MonMagasin.ajouterArticle(micArticle);
		MonMagasin.ajouterArticle(pledArticle);
		MonMagasin.ajouterArticle(rArticle);
		
		File deletorLocationFiles = new File("Locations/");
		if(deletorLocationFiles.exists())
			deletorLocationFiles.delete();
		
		File deletorArchiveFiles = new File("Archives/");
		if(deletorLocationFiles.exists())
			deletorArchiveFiles.delete();
	}
	
	public static int MenuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===MaBoutiquePhoto===");
		System.out.println("- Gérer mes articles - tapez 1");
		System.out.println("- Gérer mes clients - tapez 2");
		System.out.println("- Gérer mes locations - tapez 3");
		System.out.println("- Afficher mes recettes - tapez 4");
		System.out.println("- Quitter - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static int MenuGestionArticles() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Articles===");
		System.out.println("- Ajouter un article - tapez 1");
		System.out.println("- Supprimer un article - tapez 2");
		System.out.println("- Afficher mes articles disponibles - tapez 3");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public void AjouterArticle() {
		Scanner scanner = new Scanner(System.in);
		Scanner scannerS = new Scanner(System.in);
		System.out.println("Veuillez rentrer une référence pour l'article: ");
		int Ref = scanner.nextInt();
		
		System.out.println("Veuillez rentrer une quantité pour cette référence: ");
		int NbStock = scanner.nextInt();
		
		System.out.println("Veuillez rentrer une marque pour cet article: ");
		String Marque = scannerS.nextLine();
		
		System.out.println("Veuillez rentrer un intitulé pour cet article: ");
		String Intitule = scannerS.nextLine();
		
		System.out.println("Veuillez rentrer le prix par jour de cet article (double): ");
		double Prix = scanner.nextDouble();
		
		System.out.println("Les types d'articles disponibles pour votre magasins sont les suivants: \n");
		int ChoixType = 0;
		boolean bChoixType = true;
		
		while(bChoixType) {
			
			ChoixType = MenuChoixTypeArticle();
			switch(ChoixType) {
			
			case 1:
				Scanner scannerDA = new Scanner(System.in);
				System.out.println("Veuillez renseigner une résolution: ");
				String Res = scannerDA.nextLine();
				System.out.println("Veuillez renseigner un nombre de Pixels: ");
				int NbPixels = scannerDA.nextInt();
				DispositifAcquisition daArticle = new DispositifAcquisition(Ref, NbStock, Marque, Intitule, Prix, NbPixels, Res);
				MonMagasin.ajouterArticle(daArticle);
				bChoixType = false;
				break;
				
			case 2:
				Scanner scannerFS = new Scanner(System.in);
				System.out.println("Veuillez renseigner une taille (X):");
				int fsTailleX = scannerFS.nextInt();
				System.out.println("Veuillez renseigner une taille (Y):");
				int fsTailleY = scannerFS.nextInt();
				FondStudio fsArticle = new FondStudio(Ref, NbStock, Marque, Intitule, Prix, fsTailleX, fsTailleY);
				MonMagasin.ajouterArticle(fsArticle);
				bChoixType = false;
				break;
				
			case 3:
				MaterielTournageStabilisation mtsArticle = new MaterielTournageStabilisation(Ref, NbStock, Marque, Intitule, Prix);
				MonMagasin.ajouterArticle(mtsArticle);
				bChoixType = false;
				break;
				
			case 4:
				Scanner scannerMIC = new Scanner(System.in);
				System.out.println("Veuillez renseigner une sensibilité (double): ");
				double Sensi = scannerMIC.nextDouble();
				System.out.println("Veuillez renseigner si le micro est filaire (boolean): ");
				boolean Fil = scannerMIC.nextBoolean();
				System.out.println("Veuillez renseigner l'autonomie du micro (double): ");
				double Auto = scannerMIC.nextDouble();
				Micro micArticle = new Micro(Ref, NbStock, Marque, Intitule, Prix, Sensi, Fil, Auto);
				MonMagasin.ajouterArticle(micArticle);
				bChoixType = false;
				break;
				
			case 5:
				System.out.println("Pas géré, choisissez un autre type d'article");
				break;
				
			case 6:
				Scanner scannerPLED = new Scanner(System.in);
				System.out.println("Veuillez renseigner un nombre de Pixels: ");
				int pledNbPixels = scannerPLED.nextInt();
				PanneauLED pledArticle = new PanneauLED(Ref, NbStock, Marque, Intitule, Prix, pledNbPixels);
				MonMagasin.ajouterArticle(pledArticle);
				bChoixType = false;
				break;
				
			case 7:			
				Scanner scannerR = new Scanner(System.in);
				System.out.println("Veuillez renseigner une taille (X):");
				int rTailleX = scannerR.nextInt();
				System.out.println("Veuillez renseigner une taille (Y):");
				int rTailleY = scannerR.nextInt();
				Reflecteur rArticle = new Reflecteur(Ref, NbStock, Marque, Intitule, Prix, rTailleX, rTailleY);
				MonMagasin.ajouterArticle(rArticle);
				bChoixType = false;
				break;
				
			default:
				break;
			}
		}
	}
	
	public static int MenuChoixTypeArticle() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez en choisir un \n");
		System.out.println("-Dispositif d'acquisition - tapez 1");
		System.out.println("-Fond Studio - tapez 2");
		System.out.println("-Materiel de tournage / Stabilisation - tapez 3");
		System.out.println("-Micro - tapez 4");
		System.out.println("-Objectif - tapez 5");
		System.out.println("-Panneau LED - tapez 6");
		System.out.println("-Réflecteur - tapez 7");
		int choice = scanner.nextInt();
		return choice;
	}
	
	
	public void SupprimerArticle() {
		boolean bSupprimer = false;
		int nIndexArticle = 0;
		int nCompteur = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer la référence de l'article à supprimer: ");
		int Ref = scanner.nextInt();
		
		for(Article currentArticle : MonMagasin.getlArticles()) {
			if(Ref == currentArticle.getnReference()) {
				bSupprimer = true;
				nIndexArticle = nCompteur;
			}
			nCompteur ++;
		}
		if(bSupprimer)
			MonMagasin.retirerArticle(MonMagasin.getlArticles().get(nIndexArticle));
		
		System.out.println("L'article a été supprimé");
	}
	
	public void AfficherArticles() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez choisir le type de classement pour l'affichage des articles: ");
		String sCompare = scanner.nextLine();
		
		MonMagasin.AfficherListeArticle(sCompare);
	}
	
	public static int MenuGestionClients() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Clients===");
		System.out.println("- Ajouter un client - tapez 1");
		System.out.println("- Supprimer un client - tapez 2");
		System.out.println("- Afficher mes clients - tapez 3");
		System.out.println("- Afficher mes articles loués par un client - tapez 4");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public void AjouterClient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer un nom de client: ");
		String sNom = scanner.nextLine();
		
		System.out.println("Veuillez rentrer une adresse de client: ");
		String sAdresse = scanner.nextLine();
		
		System.out.println("Veuillez rentrer un numéro de téléphone client: ");
		String sNum = scanner.nextLine();
		
		Client Client = new Client(sNom, sAdresse, sNum);
		MonMagasin.ajouterClient(Client);
		System.out.println("Client : "+Client.getsNom()+" | "+Client.getsAdress()+" | "+Client.getsNum()+" | "+Client.getuRef()+" a été créé!");
	}
	
	public void SupprimerClient() {
		boolean bSupprimer = false;
		int nIndexClient = 0;
		int nCompteur = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer une référence de client: ");
		String sUUID = scanner.nextLine();
		
		for(Client currentClient: MonMagasin.getlClients()) {
			if(sUUID.compareTo(currentClient.getuRef().toString()) == 0) {
				bSupprimer = true;
				 nIndexClient = nCompteur;
			}
			nCompteur ++;
		}
		
		if(bSupprimer) {
			MonMagasin.supprimerClient(MonMagasin.getlClients().get(nIndexClient));
		}
	}
	
	public void AfficherClients() {
		for(Client currentClient : MonMagasin.getlClients()) {
			System.out.println("Nom du Client: "+currentClient.getsNom()+" | Adresse: "+currentClient.getsAdress()+" | Numéro: "+currentClient.getsNum()+" | référence: "+currentClient.getuRef()+" \n");
		}
	}
	
	public void AfficherLocationsClient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer une référence de client: ");
		String sUUID = scanner.nextLine();

		for(Client currentClient: MonMagasin.getlClients()) {
			if(sUUID.compareTo(currentClient.getuRef().toString()) == 0) {
				MonMagasin.AfficherLocationsEnCours(currentClient);
			}
		}
	}
	
	public static int MenuGestionLocations() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Locations===");
		System.out.println("- Créer une location - tapez 1");
		System.out.println("- Clore une location - tapez 2");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public void CreerLocation() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer une référence de client a qui attribuer la location: ");
		String refClient = scanner.nextLine();
		
		System.out.println("Veuillez rentrer une référence d'article à louer: ");
		int refArticle = scanner.nextInt();
		
		System.out.println("Veuillez rentrer la quantité voulue pour l'article à louer: ");
		int quantite = scanner.nextInt();
		
		System.out.println("Veuillez rentrer une année de fin de location: ");
		int annee = scanner.nextInt();
		
		System.out.println("Veuillez rentrer un mois de fin de location: ");
		int mois = scanner.nextInt();
		
		System.out.println("Veuillez rentrer un jour de fin de location: ");
		int jour = scanner.nextInt();
		
		for(Article currentArticle : MonMagasin.getlArticles()) {
			if(refArticle == currentArticle.getnReference()) {
				for(Client currentClient : MonMagasin.getlClients()) {
					if(refClient.compareTo(currentClient.getuRef().toString()) == 0) {
						currentArticle.louer(currentClient, quantite, new GregorianCalendar(annee, mois-1, jour));
					}
				}
			}
		}
		System.out.println("Location créée");
	}
	
	public void CloreLocation() throws IOException {
		boolean bCloreLocation = false;
		int nIndexArticle = 0;
		int nIndexClient = 0;
		int nCompteurArticle = 0;
		int nCompteurClient = 0;
		Scanner scanner = new Scanner(System.in);
		Scanner scannerS = new Scanner(System.in);
		System.out.println("Veuillez rentrer une référence d'article à rendre: ");
		int refArticle = scanner.nextInt();
		
		for(Article currentArticle : MonMagasin.getlArticles()) {
			if(refArticle == currentArticle.getnReference()) {
				System.out.println("Cet article existe bien. Affichage des locations en cours...");
				for(Client currentClient : MonMagasin.getlClients()) {
					MonMagasin.AfficherLocationsEnCours(currentClient);
				}
				nIndexArticle = nCompteurArticle;
				System.out.println("Veuillez rentrer la référence de client louant l'article à rendre: ");
				String refClient = scannerS.nextLine();
				
				
				for(Client currentClient : MonMagasin.getlClients()) {
					if(refClient.compareTo(currentClient.getuRef().toString()) == 0) {
						bCloreLocation = true;
						nIndexClient = nCompteurClient;
					}
					nCompteurClient ++;
				}
			}
			nCompteurArticle ++;
		}
		if(bCloreLocation)
			MonMagasin.getlArticles().get(nIndexArticle).FinLocation(MonMagasin.getlClients().get(nIndexClient));
		
	}
	
	public static int MenuGestionRecettes() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Recettes===");
		System.out.println("- Mes recettes - tapez 1");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public void AfficherRecettes() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer une année: ");
		int AnneeDeb = scanner.nextInt();
		System.out.println("Veuillez rentrer un mois: ");
		int MoisDeb = scanner.nextInt();
		System.out.println("Veuillez rentrer une année de fin: ");
		int AnneeFin = scanner.nextInt();
		System.out.println("Veuillez rentrer une année de début: ");
		int MoisFin = scanner.nextInt();
		
		System.out.println(MonMagasin.calculerMontant(new GregorianCalendar(AnneeDeb, MoisDeb-1, 1), new GregorianCalendar(AnneeFin, MoisFin-1, 1)));
		
	}
	
	
	public static void main(String args[]) throws IOException {
		
		boolean bMain = true;
		int userChoiceMP;
		boolean bArticles = true;
		int userChoiceMGA;
		boolean bClients = true;
		int userChoiceMGC;
		boolean bLocations = true;
		int userChoiceMGL;
		boolean bRecettes = true;
		int userChoiceMGR;
		
		Testeurv2 testeur = new Testeurv2();
		
		testeur.Initialisation();
		
		while(bMain) {
			bMain = true;
			userChoiceMP = MenuPrincipal();
			
			switch(userChoiceMP) {
			
			case 1:
				bArticles = true;
				while(bArticles) {
					userChoiceMGA = MenuGestionArticles();
					switch(userChoiceMGA) {
					
					case 1:
						testeur.AjouterArticle();
						break;
						
					case 2:
						testeur.SupprimerArticle();
						break;
						
					case 3:
						testeur.AfficherArticles();
						break;
						
					case 9:
						bArticles = false;
						System.out.println("Retour au menu prinicpal \n");
						break;
						
					default:
						break;
						
					}
				}
				break;
				
			case 2:
				bClients = true;
				while(bClients) {
					userChoiceMGC = MenuGestionClients();
					switch(userChoiceMGC) {
					
					case 1:
						testeur.AjouterClient();
						break;
						
					case 2:
						testeur.SupprimerClient();
						break;
						
					case 3:
						testeur.AfficherClients();
						break;
						
					case 4:
						testeur.AfficherLocationsClient();
						break;
						
					case 9:
						bClients = false;
						System.out.println("Retour au menu prinicpal \n");
						break;
						
					default:
						break;
					}
				}
				break;
				
			case 3:
				bLocations = true;
				while(bLocations) {
					userChoiceMGL = MenuGestionLocations();
					switch(userChoiceMGL) {
					
					case 1:
						testeur.CreerLocation();
						break;
						
					case 2:
						testeur.CloreLocation();
						break;
						
					case 9:
						bLocations = false;
						System.out.println("Retour au menu prinicpal \n");
						break;
						
					default:
						break;
					}
				}
				break;
				
			case 4:
				bRecettes = true;
				while(bRecettes) {
					userChoiceMGR = MenuGestionRecettes();
					switch(userChoiceMGR) {
					
					case 1:
						testeur.AfficherRecettes();
						break;
						
					case 9:
						bRecettes = false;
						System.out.println("Retour au menu prinicpal \n");
						break;
						
					default:
						break;
					}
				}
				break;
				
			case 9:
				bMain = false;
				System.out.println("FIN");
				break;
				
			default:
				break;
			
			}
		}
	}
}
