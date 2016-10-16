package BoutiquePhoto;

import java.util.Comparator;

public class ArticlePrixComparator implements Comparator<Article> {

	/**
	 * Constructeur
	 */
	public int compare(Article pArticle1, Article pArticle2) {
		return ((int)pArticle1.getdPrixParJour() - (int)pArticle2.getdPrixParJour());
	}

}
