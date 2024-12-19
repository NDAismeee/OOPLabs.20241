package hust.soict.dsai.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void main(String[] args) throws LimitExceededException {
		//Setup store
		initializeStore();
		
		//exit condition
		boolean exit = false;
		
		while (exit == false) {
			showMenu();
			
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
            case 0:
                exit = true;
                System.out.println("Web closed");
                break;
            case 1:
                storeMenu(sc);
                break;
            case 2:
                updateStoreMenu(sc);
                break;
            case 3:
                cartMenu(sc);
                break;
            default: 
                System.out.println("Invalid option, please choose again.");
                break;
        }

		}
	}
	
	public static void initializeStore() {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        CompactDisc cd1 = new CompactDisc("With you", "Music", "Twice", 15.26f);
        Track track1Cd1 = new Track("One Spark", 3);
        Track track2Cd1 = new Track("I Got You", 3);
        Track track3Cd1 = new Track("Bloom", 2);
        Track track4Cd1 = new Track("Rush", 3);
        cd1.addTrack(track1Cd1);
        cd1.addTrack(track2Cd1);
        cd1.addTrack(track3Cd1);
        cd1.addTrack(track4Cd1);
        
        CompactDisc cd2 = new CompactDisc("Say Yes", "Music", "Twice", 14.67f);
        Track track1Cd2 = new Track("Yes or Yes", 3);
        Track track2Cd2 = new Track("Lalala", 3);
        Track track3Cd2 = new Track("Say You Love Me", 2);
        cd2.addTrack(track1Cd2);
        cd2.addTrack(track2Cd2);
        cd2.addTrack(track3Cd2);
        
        CompactDisc cd3 = new CompactDisc("Eyes Wide Open", "Music", "Twice", 16.67f);
        Track track1Cd3 = new Track("I can't stop me", 3);
        Track track2Cd3 = new Track("Cry For Me", 3);
        Track track3Cd3 = new Track("Go Hard", 2);
        cd3.addTrack(track1Cd3);
        cd3.addTrack(track2Cd3);
        cd3.addTrack(track3Cd3);
        
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        
        Book book1 = new Book("Harry Potter: The Prequel", "Fantasy Novels", 20.34f);
        Book book2 = new Book("Harry Potter and the Sorcerer’s Stone", "Fantasy Novels", 21.44f);
        Book book3 = new Book("Christmas at Hogwarts", "Fantasy Novels", 18.42f);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
	}
	
	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	}
	public static void storeMenu(Scanner sc) throws LimitExceededException { 
		boolean back = false;
		
		while (back == false) {
			store.printStore();
			System.out.println("--------------------------------");
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. See a media’s details"); 
			System.out.println("2. Add a media to cart"); 
			System.out.println("3. Play a media"); 
			System.out.println("4. See current cart"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
            case 0:
                back = true;
                break;
            case 1:
                boolean foundDetails = false;
                while (!foundDetails) {
                    System.out.println("Enter the title of the media (type 0 to stop): ");
                    String title = sc.nextLine();
                    if (title.equals("0")) {
                        break;
                    }
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println("Details: ");
                        System.out.println(media);
                        mediaDetailsMenu(sc, media);
                        foundDetails = true;
                    } else {
                        System.out.println("----MEDIA NOT FOUND----");
                    }
                }
                break;
            case 2:
                boolean foundToAdd = false;
                while (!foundToAdd) {
                    System.out.println("Enter the title of the media (type 0 to stop): ");
                    String title = sc.nextLine();
                    if (title.equals("0")) {
                        break;
                    }
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                    	cart.addMedia(media);
                   } else {
                        System.out.println("----MEDIA NOT FOUND----");
                    }
                }
                break;
            case 3:
                boolean foundToPlay = false;
                while (!foundToPlay) {
                    System.out.println("Enter the title of the media (type 0 to stop): ");
                    String title = sc.nextLine();
                    if (title.equals("0")) {
                        break;
                    }
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        if (media instanceof Disc || media instanceof CompactDisc) {
                            media.play();
                        } else {
                            System.out.println("This is a book!");
                        }
                        foundToPlay = true;
                    } else {
                        System.out.println("----MEDIA NOT FOUND----");
                    }
                }
                break;
            case 4: 
                cartMenu(sc);
                break;    
            default:
                System.out.println("Invalid option, please choose again.");
                break;
			}
		}
	} 
	public static void mediaDetailsMenu(Scanner sc, Media media) throws LimitExceededException { 
		boolean back = false;
		while (back == false) {
		
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
		
		int option = sc.nextInt();
		sc.nextLine();
		
		switch (option) {
        case 0:
            back = true;
            break;
        case 1:
            cart.addMedia(media);
            break;
        case 2:
            if (media instanceof Disc || media instanceof CompactDisc) {
                media.play();
            } else {
                System.out.println("This is a book");
            }
            break;
        default:
            System.out.println("Invalid option, please choose again.");
            break;
    }
		}
	} 
	public static void cartMenu(Scanner sc) { 
		boolean back = false;
		while (back == false) {
		cart.printItemsOfCart();
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
		
		int option = sc.nextInt();
		sc.nextLine();
		
		switch (option) {
	        case 0: 
	            back = true;
	            break;
	        case 1:
	            System.out.println("Filter medias in cart by (1) id or (2) title:");
	            int filterOption = sc.nextInt();
	            sc.nextLine();
	            boolean found = false;
	            while (!found) {
	                if (filterOption == 1) {
	                    System.out.println("Enter the id to filter (type 0 to stop):");
	                    int id = sc.nextInt();
	                    sc.nextLine();
	                    if (id == 0) {
	                        break;
	                    }
	                    cart.searchByID(id);
	                    found = true;
	                } else if (filterOption == 2) {
	                    System.out.println("Enter the title to filter (type 0 to stop):");
	                    String title = sc.nextLine();
	                    if (title.equals("0")) {
	                        break;
	                    }
	                    cart.searchByTitle(title);
	                    found = true;
	                } else if (filterOption == 0) {
	                    break;
	                } else {
	                    System.out.println("Invalid option.");
	                }
	            }
	            break;
	        case 2:
	            System.out.println("Sort medias in cart by (1) title or (2) cost:");
	            int sortOption = sc.nextInt();
	            sc.nextLine();
	            if (sortOption == 1) {
	                cart.sortMediaByTitle();
	            } else if (sortOption == 2) {
	                cart.sortMediaByCost();
	            } else {
	                System.out.println("Invalid option.");
	            }
	            break;
	        case 3:
	            boolean foundToRemove = false;
	            while (!foundToRemove) {
	                System.out.println("Enter the title of the media (type 0 to stop): ");
	                String title = sc.nextLine();
	                if (title.equals("0")) {
	                    break;
	                }
	                Media media = cart.search(title);
	                if (media != null) {
	                    cart.removeMedia(media);
	                    foundToRemove = true;
	                } else {
	                    System.out.println("----MEDIA NOT FOUND----");
	                }
	            } 
	            break;
	        case 4:
	            boolean foundToPlay = false;
	            while (!foundToPlay) {
	                System.out.println("Enter the title of the media (type 0 to stop): ");
	                String title = sc.nextLine();
	                if (title.equals("0")) {
	                    break;
	                }
	                Media media = store.searchByTitle(title);
	                if (media != null) {
	                    if (media instanceof Disc || media instanceof CompactDisc) {
	                        media.play();
	                    } else {
	                        System.out.println("This is a book");
	                    }
	                    foundToPlay = true;
	                } else {
	                    System.out.println("----MEDIA NOT FOUND----");
	                }
	            }
	            break;
	        default:
	            System.out.println("Invalid option, please choose again.");
	            break;
			}
		} 
	}
	
	public static void updateStoreMenu(Scanner sc) {
		boolean back = false;
		while (back == false) {
			store.printStore();
			System.out.println("--------------------------------");
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Add a media to store"); 
			System.out.println("2. Remove a media from store");
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
				case 0:
					back = true;
					break;
				case 1:
					System.out.println("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit:");
					int category = sc.nextInt();
					sc.nextLine();
					
					if (category == 1) {
                        System.out.println("Enter book title: ");
                        String bookTitle = sc.nextLine();
                        System.out.println("Enter book category: ");
                        String bookCategory = sc.nextLine();
                        System.out.println("Enter book cost: ");
                        Float bookCost = sc.nextFloat();
                        sc.nextLine();

                        Book newBook = new Book(bookTitle, bookCategory, bookCost);
                        store.addMedia(newBook);
					} else if (category == 2) {
						System.out.println("Enter CD title: ");
                        String cdTitle = sc.nextLine();
                        System.out.println("Enter CD category: ");
                        String cdCategory = sc.nextLine();
                        System.out.println("Enter CD artist: ");
                        String cdArtist = sc.nextLine();
                        System.out.println("Enter CD cost: ");
                        Float cdCost = sc.nextFloat();
                        sc.nextLine();

                        CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);

                        
                        System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No:");
                        int trackChoice = sc.nextInt();
                        sc.nextLine();
                        
                        if (trackChoice == 1) {
                            System.out.println("How many tracks in your CD?");
                            int numTrack = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println("Your " + (i+1) + " track: ");
                                System.out.println("Enter track title: ");
                                String trackTitle = sc.nextLine();
                                System.out.println("Enter track length: ");
                                int trackLength = sc.nextInt();
                                sc.nextLine();

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (trackChoice == 0) {
                            store.addMedia(newCD);
                        }
					} else if (category == 3) {
						System.out.println("Enter DVD title: ");
                        String dvdTitle = sc.nextLine();
                        System.out.println("Enter DVD category: ");
                        String dvdCategory = sc.nextLine();
                        System.out.println("Enter book cost: ");
                        Float dvdCost = sc.nextFloat();
                        sc.nextLine();
                        
                        DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
                        store.addMedia(newDVD);                
                    } else if (category == 0) {
                        break;
                    } else {
                        System.out.println("Invalid option.");
					}
					break;
				
				case 2:
					boolean found = false;
					while (!found) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String titleForRemove = sc.nextLine();
                        if (titleForRemove.equals("0")) {
                            break;
                        }
                        Media media = store.searchByTitle(titleForRemove);
                        if (media != null) {
                            store.remove(media);
                            found = true;
                        } else {
                            System.out.println("----MEDIA NOT FOUND----");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
			}		
		}
	}
}
