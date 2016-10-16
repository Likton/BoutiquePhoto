package BoutiquePhoto;

import java.util.Comparator;

public class ArticleIntituleComparator implements Comparator<Article> {

	/**
	 * Constructeur
	 */
	public int compare(Article pArticle1, Article pArticle2) {
		return pArticle1.getsIntitule().compareTo(pArticle2.getsIntitule());
	}
}
