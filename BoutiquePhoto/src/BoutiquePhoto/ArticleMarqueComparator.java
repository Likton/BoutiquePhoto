package BoutiquePhoto;

import java.util.Comparator;

public class ArticleMarqueComparator implements Comparator<Article> {

	public int compare(Article pArticle1, Article pArticle2) {
		return pArticle1.getsMarque().equalsIgnoreCase(pArticle2.getsMarque());
	}
}
