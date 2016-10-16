package BoutiquePhoto;

public class DispositifAcquisition extends Article{

	private int nNbPixels;
	private String sResolution;
	
	public DispositifAcquisition(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			int pNbPixels, String pResolution) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.setnNbPixels(pNbPixels);
		this.setsResolution(pResolution);
	}

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
