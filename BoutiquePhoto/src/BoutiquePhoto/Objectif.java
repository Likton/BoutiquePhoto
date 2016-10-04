package BoutiquePhoto;

import java.util.TreeSet;

public class Objectif {

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
	
	public Objectif(TreeSet<String> pLappPhoto) {
		super();
		this.lAppPhoto = pLappPhoto;
	}
}
