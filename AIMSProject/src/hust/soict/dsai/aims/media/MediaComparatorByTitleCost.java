package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		if (m1.getTitle().compareTo(m2.getTitle()) != 0) {
			return m1.getTitle().compareTo(m2.getTitle());
		}else {
			return Float.compare(m1.getCost(), m2.getCost());
		}
	}
}
