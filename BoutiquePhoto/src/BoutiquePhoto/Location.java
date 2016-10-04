package BoutiquePhoto;

//dépendances

import java.util.Date;

public class Location {
	
	//attributs
	
	private Date DateDebut;
	private Date DateFin;
	
	
	//accesseurs
	
	public Date getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

}
