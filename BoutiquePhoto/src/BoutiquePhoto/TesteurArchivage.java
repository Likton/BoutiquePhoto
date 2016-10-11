package BoutiquePhoto;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;

public class TesteurArchivage {
	public static void main(String args[]) throws IOException {
		Location maLocation = new Location(new GregorianCalendar());
		PanneauLED Panneau1 = new PanneauLED(123456, 2, "LCD", "LCD40-60", 25.00, 300);
		PanneauLED Panneau2 = new PanneauLED(789123, 1, "LCD2", "LCD80-120", 50.00, 600);
		Reflecteur Refl1 = new Reflecteur(456789, 1, "Reflector2000", "GrandReflecteur", 30.00, 300, 300);
		maLocation.setDateFinReelle(new GregorianCalendar(2016, 9, 12));
		maLocation.setnReference(1);
		maLocation.getlArticles().add(Refl1);
		maLocation.getlArticles().add(Panneau1);
		maLocation.getlArticles().add(Panneau2);
		maLocation.archiverDonnees();
	}
}