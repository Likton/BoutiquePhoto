package BoutiquePhoto;

import java.util.Scanner;

public class Testeurv2 {
	public static int afficherMenuDepart() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==BoutiquePhoto==");
		System.out.println("- Créer un magasin - tapez 1");
		System.out.println("- Selectionner un magasin - tapez 2");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static int afficherMenuMagasin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==Menu Magagsin==");
		System.out.println("- Créer un magasin - tapez 1");
		System.out.println("- Selectionner un magasin - tapez 2");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static void main(String args[]) {
		boolean b = true;
		int userChoice = afficherMenuDepart();
		while(b) {
			switch (userChoice) {
			case 1:
				System.out.println("test1");
				int userChoiceMagasin = afficherMenuMagasin();
				switch (userChoiceMagasin) {
				case 1:
					System.out.println("test1-1");
					break;

				default:
					break;
				}
				break;
			case 2:
				System.out.println("test2");
				break;
			case 0:
				b = false;
				break;
			default:
				System.out.println("default");
				break;
			}
		}
	}
}
