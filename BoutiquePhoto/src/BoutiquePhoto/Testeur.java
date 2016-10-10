package BoutiquePhoto;

import java.util.concurrent.TimeUnit;

public class Testeur {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Client Client1 = new Client("Charles(1)");
		Client Client2 = new Client("Arthur(2)");
		
		PanneauLED Panneau1 = new PanneauLED(123456, 1, "LCD", "LCD40-60", 25.00, 300);
		PanneauLED Panneau2 = new PanneauLED(789123, 1, "LCD2", "LCD80-120", 50.00, 600);
		Reflecteur Refl1 = new Reflecteur(456789, 1, "Reflector2000", "GrandReflecteur", 30.00, 300, 300);
		
		System.out.println("Le Client1 loue le PanneauLED");
		System.out.println(Panneau1.louer(Client1));
		Client1.AfficherLocationsEnCours();
		
		System.out.println("Le Client2 tente de louer le PanneauLED");
		System.out.println(Panneau1.louer(Client2));
		Client2.AfficherLocationsEnCours();
		
		System.out.println("Le Client1 loue le Reflecteur");
		System.out.println(Refl1.louer(Client1));
		Client1.AfficherLocationsEnCours();
		
		System.out.println("Le Client1 rends ses articles");
		System.out.println(Refl1.FinLocation(Client1));
		Client1.AfficherLocationsEnCours();
		
		System.out.println("Le Client2 loue le PanneauLED");
		System.out.println(Panneau1.louer(Client2));
		Client2.AfficherLocationsEnCours();
		
		TimeUnit.SECONDS.sleep(15);
		
		System.out.println("Le Client2 loue le Reflecteur");
		System.out.println(Refl1.louer(Client2));
		Client2.AfficherLocationsEnCours();
		
		System.out.println("Le Client2 loue le Reflecteur");
		System.out.println(Panneau2.louer(Client2));
		Client2.AfficherLocationsEnCours();
		
		System.out.println("Le Client2 rends ses articles de sa 2ème location");
		System.out.println(Refl1.FinLocation(Client2));
		Client2.AfficherLocationsEnCours();
	}

}
