/**
 * @author Guitton Lucas
 * @author Chardenal Matthieu
 */

package BoutiquePhoto;

public class DispositifAcquisition extends Article{

	private int nNbPixels;
	private String sResolution;
	
	/**
	 * Constructeur
	 * @param pReference
	 * @param pNbStock
	 * @param pMarque
	 * @param pIntitule
	 * @param pPrixParJour
	 * @param pNbPixels
	 * @param pResolution
	 */
	public DispositifAcquisition(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			int pNbPixels, String pResolution) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.setnNbPixels(pNbPixels);
		this.setsResolution(pResolution);
	}

	//accesseurs
	
	public int getnNbPixels() {
		return nNbPixels;
	}

	public void setnNbPixels(int nNbPixels) {
		this.nNbPixels = nNbPixels;
	}

	public String getsResolution() {
		return sResolution;
	}

	public void setsResolution(String sResolution) {
		this.sResolution = sResolution;
	}
}
