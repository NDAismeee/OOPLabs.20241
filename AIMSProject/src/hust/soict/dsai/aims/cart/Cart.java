package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media m) {
		if (itemsOrdered.contains(m)) {
			System.out.println("'" + m.getTitle() + "' has already existed");
		}else {
			itemsOrdered.add(m);
			System.out.println("Add successfully");
		}
	}
	
	public void removeMedia(Media m) {
		if (itemsOrdered.contains(m)) {
			itemsOrdered.remove(m);
			System.out.println("Remove successfully");
		}else {
			System.out.println("'" + m.getTitle() + "' does not exist in the cart");
		}
	}
	
	public Media search(String title) {
		for (Media media: itemsOrdered) {
			if (title.equals(media.getTitle())) {
				return media;
			}
		}
		return null;
	}
	
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void printItemsOfCart() {
		System.out.println("*****************CART*****************");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************");
	}
	
	public void searchByID(int id) {
		boolean check = false;
		for (Media media: itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("The DVD is found: " + media.toString());
				check = true;
			}
		}
		
		if (check == false) {
			System.out.println("The dvd with the id: '" + id + " is not found");
		}
	}
	
	public void searchByTitle(String title) {
		Media m = search(title);
		if (m != null) {
				System.out.println("The DVD is found: " + m.toString());
			}else {
			System.out.println("The dvd with the title: '" + title + "' is not found");
		}
	}
	
	/*public boolean isMatching(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (title == itemsOrdered.get(i).getTitle()) {
				return true;
			}
		}
		return false;
	}*/
	
	public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
	
	public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
	}
}
