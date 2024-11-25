package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1); 
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 87, 20.95f);
		cart.addDigitalVideoDisc(dvd5);
		
		cart.searchDvdById(1);
		cart.searchDvdById(4);
		
		cart.serchDvdByTitle("The Lion King");
		cart.serchDvdByTitle("kkk");
		
		System.out.print("Total cost is: ");
		System.out.println(cart.totalCost());
		cart.printItemsOfCart();
	}

}
