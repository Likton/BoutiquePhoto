package BoutiquePhoto;

public class Article {

	private int nReference;
	private int nNbStock;
	private String sMarque;
	private String sIntitule;
	private double dPrixParJour;
	private boolean bDisponibilite;
	
	public boolean louer()
	{
		
		return false;
	}

	public int getnReference() {
		return nReference;
	}

	public void setnReference(int nReference) {
		this.nReference = nReference;
	}

	public int getnNbStock() {
		return nNbStock;
	}

	public void setnNbStock(int nNbStock) {
		this.nNbStock = nNbStock;
	}

	public String getsMarque() {
		return sMarque;
	}

	public void setsMarque(String sMarque) {
		this.sMarque = sMarque;
	}

	public String getsIntitule() {
		return sIntitule;
	}

	public void setsIntitule(String sIntitule) {
		this.sIntitule = sIntitule;
	}

	public double getdPrixParJour() {
		return dPrixParJour;
	}

	public void setdPrixParJour(double dPrixParJour) {
		this.dPrixParJour = dPrixParJour;
	}

	public boolean isbDisponibilite() {
		return bDisponibilite;
	}

	public void setbDisponibilite(boolean bDisponibilite) {
		this.bDisponibilite = bDisponibilite;
	}
	
	
}
