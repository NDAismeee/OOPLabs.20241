package hust.soict.dsai.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1); 
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Funtion", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 87, 20.95f);
		cart.addMedia(dvd5);
		
		cart.searchByID(1);
		cart.searchByID(4);
		
		cart.searchByTitle("The Lion King");
		cart.searchByTitle("kkk");
		
		System.out.print("Total cost is: ");
		System.out.println(cart.totalCost());
		cart.printItemsOfCart();
	}

}
