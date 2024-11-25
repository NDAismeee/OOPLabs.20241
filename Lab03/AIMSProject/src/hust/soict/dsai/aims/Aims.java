package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
	
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		//anOrder.removeDigitalVideoDisc(dvd2);
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.printItemsOfCart();
	}
}
