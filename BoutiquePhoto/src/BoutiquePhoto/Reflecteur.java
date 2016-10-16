package BoutiquePhoto;

public class Reflecteur extends AccessoireLumiere {

	// Attributs
	private int nTailleX;
	private int nTailleY;

	// Accesseurs
	public int getnTailleX() {
		return nTailleX;
	}

	public void setnTailleX(int nTailleX) {
		this.nTailleX = nTailleX;
	}

	public int getnTailleY() {
		return nTailleY;
	}

	public void setnTailleY(int nTailleY) {
		this.nTailleY = nTailleY;
	}

	/**
	 * Constructeur
	 * @param pReference
	 * @param pNbStock
	 * @param pMarque
	 * @param pIntitule
	 * @param pPrixParJour
	 * @param pTailleX
	 * @param pTailleY
	 */
	public Reflecteur(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			int pTailleX, int pTailleY) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.nTailleX = pTailleX;
		this.nTailleY = pTailleY;
	}
}
