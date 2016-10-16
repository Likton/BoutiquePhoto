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
	
	/**
	 * Constructeur	
	 * @param pReference
	 * @param pNbStock
	 * @param pMarque
	 * @param pIntitule
	 * @param pPrixParJour
	 * @param pNbLED
	 */
	public PanneauLED(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			int pNbLED) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.nNbLED = pNbLED;
	}
	
}
