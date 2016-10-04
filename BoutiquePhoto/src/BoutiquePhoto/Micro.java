package BoutiquePhoto;

public class Micro extends Article {

	// Attributs

	private double dSensibilite;
	private boolean bTypeFilaire;
	private double dAutonomie;

	// Accesseurs
	public double getdSensibilite() {
		return dSensibilite;
	}

	public void setdSensibilite(double dSensibilite) {
		this.dSensibilite = dSensibilite;
	}

	public boolean isbTypeFilaire() {
		return bTypeFilaire;
	}

	public void setbTypeFilaire(boolean bTypeFilaire) {
		this.bTypeFilaire = bTypeFilaire;
	}

	public double getdAutonomie() {
		return dAutonomie;
	}

	public void setdAutonomie(double dAutonomie) {
		this.dAutonomie = dAutonomie;
	}
	
	// Constructeur
	
	public Micro(double pSensibilite, boolean pTypeFilaire, double pAutomonie) {
		super();
		this.dSensibilite = pSensibilite;
		this.bTypeFilaire = pTypeFilaire;
		this.dAutonomie = pAutomonie;
	}

}
