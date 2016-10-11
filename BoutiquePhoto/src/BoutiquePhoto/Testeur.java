package BoutiquePhoto;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Testeur {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Magasin Casto = new Magasin("Castorama", "Mr. Arthur");
		
		Client Client1 = new Client("Charles(1)");
		Client Client2 = new Client("Arthur(2)");
		
		PanneauLED Panneau1 = new PanneauLED(123456, 2, "LCD", "LCD40-60", 25.00, 300);
		PanneauLED Panneau2 = new PanneauLED(789123, 1, "LCD2", "LCD80-120", 50.00, 600);
		Reflecteur Refl1 = new Reflecteur(456789, 1, "Reflector2000", "GrandReflecteur", 30.00, 300, 300);
		
		Casto.ajouterArticle(Panneau1);
		Casto.ajouterArticle(Panneau2);
		Casto.ajouterArticle(Refl1);
		
		System.out.println("Le Client1 loue le PanneauLED");
		System.out.println("Veuillez saisir l'année de rendu (nombre ex:2016) : ");
		System.out.println("Veuillez saisir le mois de rendu (chiffre/nombre 1-12) : ");
		System.out.println("Veuillez saisir le jour de rendu (chiffre/nombre 1-31) : ");
		Panneau1.louer(Client1, 2, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client1);
		
		System.out.println("Le Client2 tente de louer le PanneauLED");
		Panneau1.louer(Client2, 1, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client2);
		
		System.out.println("Le Client1 loue le Reflecteur");
		Refl1.louer(Client1, 1, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client1);
		
		System.out.println("Le Client1 rends ses articles");
		Refl1.FinLocation(Client1);
		Casto.AfficherLocationsEnCours(Client1);
		
		System.out.println("Le Client2 loue le PanneauLED");
		Panneau1.louer(Client2, 1, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client2);
		
		TimeUnit.SECONDS.sleep(15);
		
		System.out.println("Le Client2 loue le Reflecteur");
		Refl1.louer(Client2, 1, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client2);
		
		System.out.println("Le Client2 loue le Reflecteur");
		Panneau2.louer(Client2, 1, new GregorianCalendar(2016, 9, 12));
		Casto.AfficherLocationsEnCours(Client2);
		
		System.out.println("Le Client2 rends ses articles de sa 2ème location");
		Refl1.FinLocation(Client2);
		Casto.AfficherLocationsEnCours(Client2);
	}

}
