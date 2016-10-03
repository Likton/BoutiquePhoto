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

	// Constructeur
	
	public Reflecteur(int pTailleX, int pTailleY) {
		super();
		this.nTailleX = pTailleX;
		this.nTailleY = pTailleY;
	}
}
