package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public void addDVD(DigitalVideoDisc disc) {
		if (isMatching(disc.getTitle())) {
			System.out.println("The '" + disc.getTitle() + "' has been added before");
		} else {
			itemsInStore.add(disc);
			System.out.println("The '" + disc.getTitle() + "' has been added successflly");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (isMatching(disc.getTitle())) {
			for (int i = 0; i < itemsInStore.size(); i++) {
				if (disc.getTitle() == itemsInStore.get(i).getTitle()) {
					itemsInStore.remove(i);
					System.out.println("The '" + disc.getTitle() + "' has been removed successflly");
				}
			}
		} else {
			System.out.println("The '" + disc.getTitle() + "' hasn't been added before");
		}
	}
	
	public boolean isMatching(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (title == itemsInStore.get(i).getTitle()) {
				return true;
			}
		}
		return false;
	}
}
