package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		if (Float.compare(m1.getCost(), m2.getCost()) != 0) {
			return Float.compare(m1.getCost(), m2.getCost());
		} else {
			return m1.getTitle().compareTo(m2.getTitle());
		}
	}
}
