package soict.dsai;

import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	
	int qtyOrdered = itemsOrdered.size();
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check = true;
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (disc.getTitle() == itemsOrdered.get(i).getTitle()) {
					System.out.println("The disc has already been in the cart");
					check = false;
				}
			}
			if (check == true) {
				itemsOrdered.add(disc);
				qtyOrdered++;
				System.out.println("The disc has been added successfully");
			}
		} else {
			System.out.println("The cart is almost full");
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
}
