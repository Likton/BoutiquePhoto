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
	
	public PanneauLED(int pNbLED) {
		super();
		this.nNbLED = pNbLED;
	}
	
}
