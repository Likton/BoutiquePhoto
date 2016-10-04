package BoutiquePhoto;

public class PanneauLED extends AccessoireLumiere {
	
	// Attribut
	private int nNbLED;

	// Accesseurs
	
	public int getnNbLED() {
		return nNbLED;
	}

	public void setnNbLED(int nNbLED) {
		this.nNbLED = nNbLED;
	}
	
	// Constructeur
	
	public PanneauLED(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			int pNbLED) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.nNbLED = pNbLED;
	}
	
}
