package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	
	int qtyOrdered = itemsOrdered.size();
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check = true;
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (disc.getTitle() == itemsOrdered.get(i).getTitle()) {
					System.out.println("The " + disc.getTitle() + "disc has already been in the cart");
					check = false;
				}
			}
			if (check == true) {
				itemsOrdered.add(disc);
				qtyOrdered++;
				System.out.println("The " + disc.getTitle() + "disc has been added successfully");
			}
		} else {
			System.out.println("The cart is almost full");
		}	
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else {
			for (int i = 0; i < dvdList.length; i++) {
				addDigitalVideoDisc(dvdList[i]);
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		}else {
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvd2);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check = true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (disc.getTitle() == itemsOrdered.get(i).getTitle()) {
				itemsOrdered.remove(i);
				System.out.println("The disc has been removed successfully");
				qtyOrdered--;
				check = false;
			}
		}
		if (check == true) System.out.println("The disc does not exist");
	}
	
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public String toString(DigitalVideoDisc disc) {
		return "DVD - "+ disc.getTitle() + " - " + disc.getCategory() + " - " +  disc.getDirector()
				+ " - " + disc.getLength() + ": " + disc.getCost() + "$";
	}
	
	public void printItemsOfCart() {
		System.out.println("*****************CART*****************");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(toString(itemsOrdered.get(i)));
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************");
	}
	
	public void searchDvdById(int id) {
		boolean check = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (id == itemsOrdered.get(i).getId()) {
				System.out.println("The DVD is found: " + toString(itemsOrdered.get(i)));
				check = true;
			}
		}
		
		if (check == false) {
			System.out.println("The dvd with the id: '" + id + " is not found");
		}
	}
	
	public void serchDvdByTitle(String title) {
		if (isMatching(title)) {
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (title == itemsOrdered.get(i).getTitle()) {
					System.out.println("The DVD is found: " + toString(itemsOrdered.get(i)));
				}
			}
		}else {
			System.out.println("The dvd with the title: '" + title + "' is not found");
		}
	}
	
	public boolean isMatching(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (title == itemsOrdered.get(i).getTitle()) {
				return true;
			}
		}
		return false;
	}
}
