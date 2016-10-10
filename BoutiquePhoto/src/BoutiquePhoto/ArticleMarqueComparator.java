package BoutiquePhoto;

import java.util.Comparator;

public class ArticleMarqueComparator implements Comparator<Article> {

	public int compare(Article pArticle1, Article pArticle2) {
		int result = 0;
		if(!(pArticle1.getsMarque().equalsIgnoreCase(pArticle2.getsMarque()))) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}
}
