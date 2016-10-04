package BoutiquePhoto;

import java.util.TreeSet;

public class Objectif extends Article {

	// Attribut
	
	private TreeSet<String> lAppPhoto;
	
	// Accesseurs
	
	public TreeSet<String> getlAppPhoto() {
		return lAppPhoto;
	}

	public void setlAppPhoto(TreeSet<String> lAppPhoto) {
		this.lAppPhoto = lAppPhoto;
	}
	
	// Constructeur
	
	public Objectif(int pReference, int pNbStock, String pMarque, String pIntitule, double pPrixParJour,
			TreeSet<String> pLappPhoto) {
		super(pReference, pNbStock, pMarque, pIntitule, pPrixParJour);
		this.lAppPhoto = pLappPhoto;
	}
}
