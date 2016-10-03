package BoutiquePhoto;

public class FondStudio extends AccessoireLumiere {

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
	
	// Constructeur
	
	public FondStudio(int pTailleX, int pTailleY) {
		super();
		this.nTailleX = pTailleX;
		this.nTailleY = pTailleY;
	}
}
