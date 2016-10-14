package BoutiquePhoto;

import java.util.Scanner;

public class Testeurv2 {
	
	Magasin MonMagasin = new Magasin("MonMagasin","Moi");
	
	
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
	
	public static int MenuGestionLocations() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Locations===");
		System.out.println("- Créer une location - tapez 1");
		System.out.println("- Clore une location - tapez 2");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static int MenuGestionRecettes() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Gestion des Recettes===");
		System.out.println("- Mes recettes - tapez 1");
		System.out.println("- Retour - tapez 9");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public void AjouterClient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez rentrer un nom de client : ");
		String sNom = scanner.nextLine();
		System.out.println("Veuillez rentrer une adresse de client: ");
		String sAdresse = scanner.nextLine();
		System.out.println("Veuillez rentrer un numéro de téléphone client: ");
		String sNum = scanner.nextLine();
		Client Client = new Client(sNom, sAdresse, sNum);
		MonMagasin.ajouterClient(Client);
		System.out.println("Client : "+Client.getsNom()+" | "+Client.getsAdress()+" | "+Client.getsNum()+" | "+Client.getuRef()+" a été créé!");
	}
	
	public void AfficherClients() {
		for(Client currentClient : MonMagasin.getlClients()) {
			System.out.println("Nom du Client: "+currentClient.getsNom()+" | référence: "+currentClient.getuRef()+" | adresse: "+currentClient.getsAdress()+" | numéro: "+currentClient.getsNum()+" \n");
		}
	}
	
	
	public static void main(String args[]) {
		
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
		
		while(bMain) {
			
			userChoiceMP = MenuPrincipal();
			
			switch(userChoiceMP) {
			
			case 1:
				while(bArticles) {
					userChoiceMGA = MenuGestionArticles();
					switch(userChoiceMGA) {
					
					case 1:
						break;
						
					case 2:
						break;
						
					case 3:
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
				while(bClients) {
					userChoiceMGC = MenuGestionClients();
					switch(userChoiceMGC) {
					
					case 1:
						testeur.AjouterClient();
						break;
						
					case 2:
						break;
						
					case 3:
						testeur.AfficherClients();
						break;
						
					case 4:	
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
				while(bLocations) {
					userChoiceMGL = MenuGestionLocations();
					switch(userChoiceMGL) {
					
					case 1:
						break;
						
					case 2:
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
				while(bRecettes) {
					userChoiceMGR = MenuGestionRecettes();
					switch(userChoiceMGR) {
					
					case 1:
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
