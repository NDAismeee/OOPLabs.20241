package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media m) {
		if (itemsInStore.contains(m)) {
			System.out.println("'" + m.getTitle() + "' has already existed");
		}else {
			itemsInStore.add(m);
			System.out.println("Add successfully");
		}
	}
	
	public void remove(Media m) {
		if (itemsInStore.contains(m)) {
			itemsInStore.remove(m);
			System.out.println("Remove successfully");
		}else {
			System.out.println("'" + m.getTitle() + "' does not exist in the store");
		}
	}
	
	public Media searchByTitle(String title) {
		for (Media media: itemsInStore) {
			if (title.equals(media.getTitle())) {
				return media;
			}
		}
		return null;
	}
	
	public void printStore() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
	}
}
